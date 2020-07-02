package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.Movement;
import com.team3.services.MovementService;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;

    // get movement by Id
    @GetMapping("/{id}")
    public Movement getMovementById(@PathVariable int id) {
        Movement m = movementService.getMovementById(id);
       
       
                return m;
    }

    @GetMapping
    public List<Movement> getMovements() {
        return movementService.getMovements();
    }

    /* save movement*/
    @PostMapping
    public Movement saveMovement(@RequestBody Movement movement) {
        return movementService.saveMovement(movement);
    }

    // UPDATE current user
    @PutMapping
    public Movement updateMovement(@RequestBody Movement movement) {
        return movementService.updateMovement(movement);
    }

}
