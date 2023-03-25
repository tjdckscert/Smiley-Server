package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
@MappedSuperclass
public class UserMedicalInfo implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer calibrationStatus;

    @Column
    private LocalDate startDate;

    @Column
    private JSONArray surveyResult;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public UserMedicalInfo(Integer id, Integer calibrationStatus, LocalDate startDate, JSONArray surveyResult, User user, Hospital hospital) {
        this.id = id;
        this.calibrationStatus = calibrationStatus;
        this.startDate = startDate;
        this.surveyResult = surveyResult;
        this.user = user;
        this.hospital = hospital;
    }
}
