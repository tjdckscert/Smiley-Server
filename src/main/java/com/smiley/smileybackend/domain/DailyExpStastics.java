package com.smiley.smileybackend.domain;


import com.smiley.smileybackend.dto.user.ExpJsonDto;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class DailyExpStastics {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate date;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<ExpJsonDto> expStastics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", foreignKey = @ForeignKey(name = "fk_dailyexpstastics_user"))
    private User user;


    @Builder
    public DailyExpStastics(Integer id, LocalDate date, List<ExpJsonDto> expStastics, User user) {
        this.id = id;
        this.date = date;
        this.expStastics = expStastics;
        this.user = user;
    }
}
