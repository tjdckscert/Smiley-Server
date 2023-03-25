package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Tier {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private Tier tierName;

    @Column
    private Integer expStart;

    @Column
    private Integer expEnd;

    @Builder
    public Tier(Integer id, Tier tierName, Integer expStart, Integer expEnd) {
        this.id = id;
        this.tierName = tierName;
        this.expStart = expStart;
        this.expEnd = expEnd;
    }
}
