package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.Movement;
import com.team3.models.MovementStatus;
import com.team3.services.MovementService;
import com.team3.services.MovementStatusService;
import com.team3.services.MovementTypeService;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;
    @Autowired
    MovementStatusService mss;
    @Autowired
    MovementTypeService mts;

    // get movement by Id
    @GetMapping("/{id}")
    public Movement getMovementById(@PathVariable int id) {

        Movement m = movementService.getMovementById(id);

        return m;
    }

    @GetMapping("/status/{stat}")
    public Movement[] getMovementsByStatus(@PathVariable String stat) {

        int id = mss.getMovementStatusByName(stat).getId();

        List<Movement> m = movementService.getMovementsByStatus(id);
        Movement[] moves = new Movement[m.size()];
        m.toArray(moves);
        return moves;
    }

    @GetMapping("/type/{type}")
    public Movement[] getMovementsByType(@PathVariable String type) {

        int id = mts.getMovementTypeByName(type).getId();

        List<Movement> m = movementService.getMovementsByType(id);
        Movement[] moves = new Movement[m.size()];
        m.toArray(moves);
        return moves;
    }

    @GetMapping
    public Movement[] getMovements() {
        List<Movement> re = movementService.getMovements();
        Movement[] moves = new Movement[re.size()];
        re.toArray(moves);
        return moves;
    }

    @GetMapping("/search/{word}")
    public Movement[] getSearch(@PathVariable String word) {
        List<Movement> re = movementService.getMovements();
        Movement[] moves = new Movement[re.size()];
        re.toArray(moves);
        Movement[] found = new Movement[re.size()];
        int pos = 0;
        String lower = word.toLowerCase();
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].getName().toLowerCase().indexOf(lower)!= -1) {
                found[pos] = moves[i];
                pos++;
                
            }
            
            
            
        }
            System.out.println(found);
        return found;
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
