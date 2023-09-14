package com.smiley.smileybackend._05_hospital.repository;

import com.smiley.smileybackend._05_hospital.domain.Hospital;
import com.smiley.smileybackend._05_hospital.domain.keys.Hospitalkeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Hospitalkeys> {

    @Query("select h from Hospital h where h.hPid = :hPid")
    Optional<Hospital> findByHPid(@Param("hPid") String hPid);


    @Query(nativeQuery = true,value = "SELECT *,\n" +
            "(6371*acos(cos(radians( :userlan))*cos(radians(wgs84lat))*cos(radians(wgs84lon) \n" +
            "-radians( :userlon))+sin(radians( :userlan))*sin(radians(wgs84lat)))) \n" +
            "AS distance \n" +
            "FROM hospital \n" +
            "HAVING distance <= :distance \n" +
            "ORDER BY distance ;")
    List<Hospital> findNearHospitals(@Param("distance") Double distance, @Param("userlan") Double  userlan, @Param("userlon") Double  userlon);


    //@Query("select h from Hospital h where h.isPartner = true")
    List<Hospital> findByIsPartnerIsTrue();

    @Query(nativeQuery = true,value = "SELECT *,\n" +
            "(6371*acos(cos(radians( :userlan))*cos(radians(wgs84lat))*cos(radians(wgs84lon) \n" +
            "-radians( :userlon))+sin(radians( :userlan))*sin(radians(wgs84lat)))) \n" +
            "AS distance \n" +
            "FROM hospital \n" +
            "WHERE isPartner = true" +
            "HAVING distance <= :distance \n" +
            "ORDER BY distance ;")
    List<Hospital> findNearPartnerHospitals(@Param("distance") Double distance, @Param("userlan") Double  userlan, @Param("userlon") Double  userlon);




}
