package com.example.testXtensusBack.Repository;

import com.example.testXtensusBack.Entity.Gouvernement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GouvernementRepository extends JpaRepository<Gouvernement,Long> {
}
