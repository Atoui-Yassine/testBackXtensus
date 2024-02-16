package com.example.testXtensusBack.Service;

import com.example.testXtensusBack.Entity.Gouvernement;
import com.example.testXtensusBack.Entity.Personne;

import java.util.List;

public interface IGouvernementService {
    List<Gouvernement> getAll();
    Gouvernement getById(Long id);
    Gouvernement createGouvernement(Gouvernement gouvernement);
    void deleteGouvernementById(Long id);
    Gouvernement updateGouvernementById(long id,Gouvernement gouvernement);
}
