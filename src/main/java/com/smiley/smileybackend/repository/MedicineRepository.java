package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,String> {

}
