package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


    @Query("select b from Booking b where b.reservDate < CURRENT_DATE and User_ID = :userid")
    List<Booking> findPastBooking (@Param(value = "userid") Integer userID);

    @Query("select b from Booking b where b.reservDate > CURRENT_DATE and User_ID = :userid")
    Booking findPresentBooking (@Param(value = "userid") Integer userID);
}
