package com.smiley.smileybackend._01_user.domain;


import com.smiley.smileybackend.domain.enums.DayOfWeek;
import com.smiley.smileybackend.domain.enums.RepeatPeriod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

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
    private DayOfWeek dayOfWeek;

    @Enumerated(EnumType.STRING)
    private RepeatPeriod repeatPeriod;

    @OneToMany(mappedBy = "checklist", cascade = CascadeType.PERSIST)
    private List<ChecklistResult> checklistChecklistResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_number", foreignKey = @ForeignKey(name = "fk_checklist_user"))
    private User user;

    @Builder
    public Checklist(Integer id, String title, String memo, OffsetDateTime time, Integer alarm, DayOfWeek dayOfWeek, RepeatPeriod repeatPeriod, List<ChecklistResult> checklistChecklistResults, User user) {
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
