package com.smiley.smileybackend._06_booking.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend._01_user.domain.User;
import com.smiley.smileybackend._05_hospital.domain.Hospital;
import com.smiley.smileybackend._06_booking.dto.BookingInfoDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = {"user","hospital"})
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime reservDate;

    @Column(length = 500)
    private String memo;

    @Column(length = 500,unique = true)
    private String bookingNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_number", foreignKey = @ForeignKey(name = "fk_booking_user"))
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "hPid", foreignKey = @ForeignKey(name = "fk_booking_hospital")),
    })
    private Hospital hospital;

    @Builder
    public Booking(Integer id, LocalDateTime reservDate, String memo, String bookingNumber, User user, Hospital hospital) {
        this.id = id;
        this.reservDate = reservDate;
        this.memo = memo;
        this.bookingNumber = bookingNumber;
        this.user = user;
        this.hospital = hospital;
    }

    public void Booking(BookingInfoDto bookingInfoDto, Hospital hospital) {
        this.reservDate = bookingInfoDto.getReservDate();
        this.memo = bookingInfoDto.getMemo();
        this.hospital=hospital;
    }

}
