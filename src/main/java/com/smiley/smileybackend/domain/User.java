package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "\"user\"")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String email;

    @Column(nullable = false, length = 200)
    private String phoneToken;

    @Column(length = 45)
    private String name;

    @Column
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private Set<UserDevice> userUserDevices;

    @OneToMany(mappedBy = "user")
    private Set<Userbadge> userBadges;

    @OneToMany(mappedBy = "user")
    private Set<DailyWearTime> userDailyWearTimes;

    @OneToMany(mappedBy = "user")
    private Set<Booking> userBookings;

    @OneToMany(mappedBy = "user")
    private Set<DailyExpStastics> userDailyExpStasticss;

    @OneToMany(mappedBy = "user")
    private Set<Checklist> userChecklists;

    @ManyToMany
    @JoinTable(
            name = "user_badge",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private Set<Badge> userBadgeBadges;

    @OneToMany(mappedBy = "user")
    private Set<FacialResult> userFacialResults;

    @OneToMany(mappedBy = "user")
    private Set<UserMedicalInfo> userUserMedicalInfos;

    @OneToMany(mappedBy = "user")
    private Set<TotalExpStastics> userTotalExpStasticss;

    @Builder
    public User(Integer id, String email, String phoneToken, String name, LocalDate birthDate, Set<UserDevice> userUserDevices, Set<DailyWearTime> userDailyWearTimes, Set<Booking> userBookings, Set<DailyExpStastics> userDailyExpStasticss, Set<Checklist> userChecklists, Set<Badge> userBadgeBadges, Set<FacialResult> userFacialResults, Set<UserMedicalInfo> userUserMedicalInfos, Set<TotalExpStastics> userTotalExpStasticss) {
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
        this.userBadgeBadges = userBadgeBadges;
        this.userFacialResults = userFacialResults;
        this.userUserMedicalInfos = userUserMedicalInfos;
        this.userTotalExpStasticss = userTotalExpStasticss;
    }
}
