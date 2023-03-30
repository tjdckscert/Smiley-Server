package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.List;


@Entity
@Table(name = "\"user\"")
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50,unique = true)
    private String email;

    @Column(nullable = false, length = 200)
    private String phoneToken;

    @Column(length = 45)
    private String name;

    @Column
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<UserDevice> userUserDevices;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<DailyWearTime> userDailyWearTimes;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Booking> userBookings;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<DailyExpStastics> userDailyExpStasticss;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Checklist> userChecklists;

    @ManyToMany()
    @JoinTable(
            name = "user_badge",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private List<Badge> userBadges;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<FacialResult> userFacialResults;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<UserMedicalInfo> userUserMedicalInfos;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<TotalExpStastics> userTotalExpStasticss;

    @Builder
    public User(Integer id, String email, String phoneToken, String name, LocalDate birthDate, List<UserDevice> userUserDevices, List<DailyWearTime> userDailyWearTimes, List<Booking> userBookings, List<DailyExpStastics> userDailyExpStasticss, List<Checklist> userChecklists, List<Badge> userBadges, List<FacialResult> userFacialResults, List<UserMedicalInfo> userUserMedicalInfos, List<TotalExpStastics> userTotalExpStasticss) {
        this.id = id;
        this.email = email;
        this.phoneToken = phoneToken;
        this.name = name;
        this.birthDate = birthDate;
        this.userUserDevices = userUserDevices;
        this.userDailyWearTimes = userDailyWearTimes;
        this.userBookings = userBookings;
        this.userDailyExpStasticss = userDailyExpStasticss;
        this.userChecklists = userChecklists;
        this.userBadges = userBadges;
        this.userFacialResults = userFacialResults;
        this.userUserMedicalInfos = userUserMedicalInfos;
        this.userTotalExpStasticss = userTotalExpStasticss;
    }
}
