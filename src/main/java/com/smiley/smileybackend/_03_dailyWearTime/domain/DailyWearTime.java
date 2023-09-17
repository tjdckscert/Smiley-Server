package com.smiley.smileybackend._03_dailyWearTime.domain;


import com.smiley.smileybackend._01_user.domain.User;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class DailyWearTime {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate wearDate;

    @Column
    private Integer totalWearTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", foreignKey = @ForeignKey(name = "fk_dailyweartime_user"))
    private User user;

    @Builder
    public DailyWearTime(Integer id, LocalDate wearDate, Integer totalWearTime, User user) {
        this.id = id;
        this.wearDate = wearDate;
        this.totalWearTime = totalWearTime;
        this.user = user;
    }
}
