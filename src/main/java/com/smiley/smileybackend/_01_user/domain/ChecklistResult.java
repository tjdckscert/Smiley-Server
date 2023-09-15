package com.smiley.smileybackend._01_user.domain;


import com.smiley.smileybackend._01_user.domain.Checklist;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class ChecklistResult {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checklist_id", foreignKey = @ForeignKey(name = "fk_checklistresult_checklist"))
    private Checklist checklist;

    @Builder
    public ChecklistResult(Integer id, LocalDate date, Checklist checklist) {
        this.id = id;
        this.date = date;
        this.checklist = checklist;
    }
}
