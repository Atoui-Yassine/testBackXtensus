package com.example.testXtensusBack.Service;

import com.example.testXtensusBack.Entity.Gouvernement;
import com.example.testXtensusBack.Entity.Personne;
import com.example.testXtensusBack.Exception.EntityNotFoundException;
import com.example.testXtensusBack.Repository.GouvernementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GouvernementService implements IGouvernementService{
    @Autowired
    private GouvernementRepository gouvernementRepository;

    @Override
    public List<Gouvernement> getAll() {
        return gouvernementRepository.findAll();
    }

    @Override
    public Gouvernement getById(Long id) {
        Gouvernement gouvernement=gouvernementRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Gouvernement not found with id :" +id));
        return gouvernement;
    }

    @Override
    public Gouvernement createGouvernement(Gouvernement gouvernement) {
        return gouvernementRepository.save(gouvernement);
    }

    @Override
    public void deleteGouvernementById(Long id) {

        try {
            gouvernementRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){ //générer une EntityNotFoundException avec le message approprié
            throw new EntityNotFoundException(" Gouvernement not found with id :" +id);
        }
    }

    @Override
    public Gouvernement updateGouvernementById(long id, Gouvernement gouvernement) {
       Gouvernement gouvernement1=this.getById(id);
        if (!gouvernement.getNomGouvernement().isEmpty() && gouvernement.getNomGouvernement() != null){
            gouvernement1.setNomGouvernement(gouvernement.getNomGouvernement());
            gouvernementRepository.save(gouvernement1);
        }else {
            throw new IllegalArgumentException(" Nomgouvernement cannot be null or empty ");
        }
        return gouvernement1;
    }

}
