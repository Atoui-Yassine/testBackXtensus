package com.example.testXtensusBack.Repository;

import com.example.testXtensusBack.Entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {

}
