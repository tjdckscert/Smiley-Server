package com.smiley.smileybackend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class DailyExpStastics {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate date;

    @Column(columnDefinition = "text")
    private JSONArray expStastics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public DailyExpStastics(Integer id, LocalDate date, JSONArray expStastics, User user) {
        this.id = id;
        this.date = date;
        this.expStastics = expStastics;
        this.user = user;
    }
}
