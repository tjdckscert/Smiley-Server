package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.keys.Hospitalkeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Hospitalkeys> {

    @Query("select h from Hospital h where h.hPid = :hPid")
    Optional<Hospital> findByHPid(@Param("hPid") String hPid);
}
