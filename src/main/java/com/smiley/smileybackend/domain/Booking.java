package com.smiley.smileybackend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private OffsetDateTime reservDate;

    @Column(length = 500)
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public Booking(Integer id, OffsetDateTime reservDate, String memo, User user, Hospital hospital) {
        this.id = id;
        this.reservDate = reservDate;
        this.memo = memo;
        this.user = user;
        this.hospital = hospital;
    }
}
