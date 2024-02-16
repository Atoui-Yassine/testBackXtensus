package com.example.testXtensusBack.Controller;

import com.example.testXtensusBack.Entity.Gouvernement;
import com.example.testXtensusBack.Service.IGouvernementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/gouvernement")
public class GouvernementController {

    @Autowired
    private IGouvernementService iGouvernementService;

    @PostMapping
    public ResponseEntity<Gouvernement> createGouvernement(@Valid @RequestBody Gouvernement gouvernement){
        return ResponseEntity.ok().body(iGouvernementService.createGouvernement(gouvernement));
    }
    @GetMapping
    public ResponseEntity<List<Gouvernement>> listGouvernements(){
        return ResponseEntity.ok().body(iGouvernementService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gouvernement> getGouvernementById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(iGouvernementService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGouvernement(@PathVariable("id") Long id, @RequestBody Gouvernement gouvernement){
        try {
            return ResponseEntity.ok().body(iGouvernementService.updateGouvernementById(id,gouvernement));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + ex.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGouvernementById(@PathVariable("id") Long id){
        iGouvernementService.deleteGouvernementById(id);
        return ResponseEntity.ok().body("{\"Status\": \"Successful Deletion\"}");

    }
}
