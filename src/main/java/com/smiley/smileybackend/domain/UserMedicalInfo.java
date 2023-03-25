package com.smiley.smileybackend.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONArray;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class UserMedicalInfo implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer calibrationStatus;

    @Column
    private LocalDate startDate;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<String> surveyResult;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public UserMedicalInfo(Integer id, Integer calibrationStatus, LocalDate startDate, List<String> surveyResult, User user, Hospital hospital) {
        this.id = id;
        this.calibrationStatus = calibrationStatus;
        this.startDate = startDate;
        this.surveyResult = surveyResult;
        this.user = user;
        this.hospital = hospital;
    }
}
