package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {

    @Query(value = "select * from (select *, ROW_NUMBER() OVER(order by id desc) as rnum from magazine m) Magazine where rnum between 1 and :number",nativeQuery = true)
    List<Magazine> findNumbeOfMagazines(@Param("number") Integer number);
}
