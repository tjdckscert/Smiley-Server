package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Booking;
import com.smiley.smileybackend.domain.Hospital;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    List<Booking> findByUser_Id(@Param(value = "user_id") Integer id);
}
