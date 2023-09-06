package com.smiley.smileybackend._01_user.domain;

import com.smiley.smileybackend.domain.enums.TierName;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Tier {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TierName tierName;

    @Column
    private Integer expStart;

    @Column
    private Integer expEnd;

    @Builder
    public Tier(Integer id, TierName tierName, Integer expStart, Integer expEnd) {
        this.id = id;
        this.tierName = tierName;
        this.expStart = expStart;
        this.expEnd = expEnd;
    }
}
