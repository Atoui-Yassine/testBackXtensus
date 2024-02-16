package com.example.testXtensusBack.Controller;

import com.example.testXtensusBack.DTOs.PersonneDto;
import com.example.testXtensusBack.Entity.Personne;
import com.example.testXtensusBack.Service.IPersonneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {

    @Autowired
    private IPersonneService personneService;
    @PostMapping
    public ResponseEntity<Personne> createPersonne(@Valid @RequestBody Personne personne){
        return ResponseEntity.ok().body(personneService.createPersonne(personne));
    }
    @GetMapping
    public ResponseEntity<List<Personne>> listOfPersonnes(){
        return ResponseEntity.ok().body(personneService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(personneService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonne(@PathVariable("id") Long id, @RequestBody PersonneDto personne){
        try {
            return ResponseEntity.ok().body(personneService.updatePersonneById(id,personne));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + ex.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonne(@PathVariable("id") Long id){
        personneService.deletePersonneById(id);
        return ResponseEntity.ok().body("{\"Status\": \"Successful Deletion\"}");

    }
    @PostMapping("/{personneId}")
    public ResponseEntity<Personne> addGouvernementToPersonne(@PathVariable("personneId") long personneId,@RequestParam("gouvernementId") long gouvernementId){
        return ResponseEntity.ok().body(personneService.addGouvernementToPersonne(personneId,gouvernementId));
    }

}
