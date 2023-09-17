package com.smiley.smileybackend._07_drug.repository;

import com.smiley.smileybackend._07_drug.domain.ContraindicatedDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContraindicatedDrugRepository extends JpaRepository<ContraindicatedDrug,String> {

    @Query("SELECT d.itemNameKor FROM ContraindicatedDrug d")
    List<String> findAllItemName();

    ContraindicatedDrug findByItemNameKor(String itemName);

}
