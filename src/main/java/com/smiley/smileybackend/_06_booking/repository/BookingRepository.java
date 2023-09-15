package com.smiley.smileybackend._06_booking.repository;

import com.smiley.smileybackend._06_booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


    @Query("select b from Booking b where b.reservDate < CURRENT_DATE and User_User_Number = :userNumber")
    List<Booking> findPastBooking (@Param(value = "userNumber") String  userNumber);

    @Query("select b from Booking b where b.reservDate > CURRENT_DATE and User_User_Number = :userNumber")
    Booking findPresentBooking (@Param(value = "userNumber") String  userNumber);
}
