package com.smiley.smileybackend.drug.repository;

import com.smiley.smileybackend.drug.domain.ContraindicatedDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface ContraindicatedDrugRepository extends JpaRepository<ContraindicatedDrug,String> {

    @Query("SELECT d.itemNameKor FROM ContraindicatedDrug d")
    List<String> findAllItemName();

    ContraindicatedDrug findByItemNameKor(String itemName);

}
