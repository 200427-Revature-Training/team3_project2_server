package com.team3.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.team3.interfaceRepositories.InterfaceUserRepo;
import com.team3.models.LoginRequest;
import com.team3.models.SignUpRequest;
import com.team3.models.User;
import com.team3.payload.ApiResponse;
import com.team3.payload.JwtAuthenticationResponse;
import com.team3.repositories.UserRepository;
import com.team3.security.CustomUserDetailsService;
import com.team3.security.JwtTokenProvider;
import com.team3.security.SecurityConfig;
import com.team3.security.UserPrincipal;
import com.team3.services.UserService;

@Import(SecurityConfig.class) //attempted bug fix
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	// DELETE user
	@DeleteMapping
	void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
	
	// UPDATE current user
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	
	// GET user by ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	// GET user by email
	@GetMapping//("/{email}")
	public User getUserByEmail(@RequestParam(value = "email") String email) {
		return userService.getUserByEmail(email);
	}
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InterfaceUserRepo userRepoInter;
	
	//@Autowired
	//UserRoleRepository userRoleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	//OLD METHOD
	// POST new user
	//@PostMapping("/signup")
	//public User saveUser(@RequestBody User user) {
	//	return userService.saveUser(user);
	//}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if(userRepoInter.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email address already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		//Creating user's account
		User user = new User(signUpRequest.getEmail(), signUpRequest.getPassword(), 
				signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getRole());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User result = userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/api/users/{email}")
				.buildAndExpand(result.getEmail()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
		
	}
	
	 
	//removing the @Valid annotation that was before @RequestBody, seeing if that makes a difference
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getEmail(), loginRequest.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
	
	
}






























