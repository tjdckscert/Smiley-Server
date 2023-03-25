package com.smiley.smileybackend.domain;


import com.smiley.smileybackend.domain.enums.Day_of_week;
import com.smiley.smileybackend.domain.enums.Repeat_period;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Checklist {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(length = 200)
    private String memo;

    @Column
    private OffsetDateTime time;

    @Column
    private Integer alarm;

    @Enumerated(EnumType.STRING)
    private Day_of_week dayOfWeek;

    @Enumerated(EnumType.STRING)
    private Repeat_period repeatPeriod;

    @OneToMany(mappedBy = "checklist")
    private List<ChecklistResult> checklistChecklistResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Checklist(Integer id, String title, String memo, OffsetDateTime time, Integer alarm, Day_of_week dayOfWeek, Repeat_period repeatPeriod, List<ChecklistResult> checklistChecklistResults, User user) {
        this.id = id;
        this.title = title;
        this.memo = memo;
        this.time = time;
        this.alarm = alarm;
        this.dayOfWeek = dayOfWeek;
        this.repeatPeriod = repeatPeriod;
        this.checklistChecklistResults = checklistChecklistResults;
        this.user = user;
    }
}
