package com.smiley.smileybackend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
public class DailyWearTime {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate wearDate;

    @Column
    private Integer totalWearTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_dailyweartime_user"))
    private User user;

    @Builder
    public DailyWearTime(Integer id, LocalDate wearDate, Integer totalWearTime, User user) {
        this.id = id;
        this.wearDate = wearDate;
        this.totalWearTime = totalWearTime;
        this.user = user;
    }
}
