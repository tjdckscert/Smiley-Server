package com.smiley.smileybackend.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend.dto.user.EditBookingDto;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_number", foreignKey = @ForeignKey(name = "fk_booking_user"))
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumns({
            @JoinColumn(name = "hPid", foreignKey = @ForeignKey(name = "fk_booking_hospital")),
            @JoinColumn(name = "is_partner"),
    })
    private Hospital hospital;

    @Builder
    public Booking(Integer id, LocalDateTime  reservDate, String memo, User user, Hospital hospital) {
        this.id = id;
        this.reservDate = reservDate;
        this.memo = memo;
        this.user = user;
        this.hospital = hospital;
    }

    public void editBooking(EditBookingDto editBookingDto, Hospital hospital) {
        this.reservDate = editBookingDto.getReservDate();
        this.memo = editBookingDto.getMemo();
        this.hospital=hospital;
    }
}
