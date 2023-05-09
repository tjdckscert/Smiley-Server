package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.keys.Hospitalkeys;
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
}
