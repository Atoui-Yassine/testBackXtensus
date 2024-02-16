package com.example.testXtensusBack.Service;

import com.example.testXtensusBack.DTOs.PersonneDto;
import com.example.testXtensusBack.Entity.Gouvernement;
import com.example.testXtensusBack.Entity.Personne;
import com.example.testXtensusBack.Exception.EntityNotFoundException;
import com.example.testXtensusBack.Repository.PersonneRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PersonneService implements IPersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private IGouvernementService iGouvernementService;
    @Autowired
    private ModelMapper mapper;
    @Override
    public List<Personne> getAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne getById(Long id) {
        Personne personne=personneRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Personne not found with id :" + id));
        return personne;
    }

    @Override
    public Personne createPersonne(Personne personne) {

            return personneRepository.save(personne);

    }

    @Override
    public void deletePersonneById(Long id) {

        try {
            personneRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){ //générer une EntityNotFoundException avec le message approprié
            throw new EntityNotFoundException(" Personne not found with id :" +id);
        }

    }

    @Override
    public Personne updatePersonneById(long id, PersonneDto personne) {
        Personne user= this.getById(id);

            if (!personne.getNom().isEmpty() && !personne.getPrenom().isEmpty()) {
                user.setNom(personne.getNom());
                user.setPrenom(personne.getPrenom());
                if (!personne.getMail().isEmpty()) {
                    user.setMail(personne.getMail());
                }
                if (!personne.getTel().isEmpty()) {
                    user.setTel(personne.getTel());
                }
                if(personne.getGouvernementID() != 0){
                    Gouvernement gouvernement=iGouvernementService.getById(personne.getGouvernementID());
                    user.setGouvernement(gouvernement);
                }
                personneRepository.save(user);
            } else {

                throw new IllegalArgumentException("Nom and prenom cannot be null or empty");
            }

        return user;
    }

    @Override
    public Personne addGouvernementToPersonne(long personneId,long gouvernementId) {
        Gouvernement gouvernement=iGouvernementService.getById(gouvernementId);
        Personne personne=this.getById(personneId);
        personne.setGouvernement(gouvernement);
        personneRepository.save(personne);
        return personne;
    }
}
