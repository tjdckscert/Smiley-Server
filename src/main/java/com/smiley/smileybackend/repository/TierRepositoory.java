package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TierRepositoory extends JpaRepository<Tier,Integer> {

    @Query("SELECT t FROM Tier t where t.expEnd > :exp and t.expStart<= :exp")
    Tier findByExpStartAfterBefore(@Param("exp") Integer exp);
}
