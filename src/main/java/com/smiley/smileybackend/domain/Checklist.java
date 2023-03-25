package com.smiley.smileybackend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @Column(nullable = false)
    private String dayOfWeek;

    @Column(nullable = false)
    private String repeatPeriod;

    @OneToMany(mappedBy = "checklist")
    private Set<ChecklistResult> checklistChecklistResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Checklist(Integer id, String title, String memo, OffsetDateTime time, Integer alarm, String dayOfWeek, String repeatPeriod, Set<ChecklistResult> checklistChecklistResults, User user) {
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
