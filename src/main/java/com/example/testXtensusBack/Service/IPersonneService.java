package com.example.testXtensusBack.Service;

import com.example.testXtensusBack.DTOs.PersonneDto;
import com.example.testXtensusBack.Entity.Personne;

import java.util.List;

public interface IPersonneService {
    List<Personne> getAll();
    Personne getById(Long id);
    Personne createPersonne(Personne personne);
    void deletePersonneById(Long id);
    Personne updatePersonneById(long id, PersonneDto persone);
    Personne addGouvernementToPersonne(long PersonneId,long gouvernementId);
}
