package com.smiley.smileybackend.domain;

import com.example.deuproject.domain.keys.Hospitalkeys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@IdClass(Hospitalkeys.class)
public class Hospital {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(nullable = false)
    private Boolean isPartner;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 200)
    private String rnum;

    @Column(length = 200)
    private String dutyAddr;

    @Column(length = 200)
    private String dutyDiv;

    @Column(length = 200)
    private String dutyDivNam;

    @Column(length = 20)
    private String dutyEmcls;

    @Column(length = 200)
    private String dutyEmclsName;

    @Column(length = 200)
    private String dutyEryn;

    @Column(length = 200)
    private String dutyEtc;

    @Column(length = 200)
    private String dutyInf;

    @Column(length = 200)
    private String dutyMapimg;

    @Column(length = 200)
    private String dutyName;

    @Column(length = 20)
    private String dutyTel1;

    @Column(length = 20)
    private String dutyTel3;

    @Column(length = 20)
    private String dutyTime1c;

    @Column(length = 20)
    private String dutyTime2c;

    @Column(length = 20)
    private String dutyTime3c;

    @Column(length = 20)
    private String dutyTime4c;

    @Column(length = 20)
    private String dutyTime5c;

    @Column(length = 20)
    private String dutyTime6c;

    @Column(length = 20)
    private String dutyTime7c;

    @Column(length = 20)
    private String dutyTime8c;

    @Column(length = 20)
    private String dutyTime1s;

    @Column(length = 20)
    private String dutyTime2s;

    @Column(length = 20)
    private String dutyTime3s;

    @Column(length = 20)
    private String dutyTime4s;

    @Column(length = 20)
    private String dutyTime5s;

    @Column(length = 20)
    private String dutyTime6s;

    @Column(length = 20)
    private String dutyTime7s;

    @Column(length = 20)
    private String dutyTime8s;

    @Column(length = 200)
    private String hpid;

    @Column(length = 200)
    private String postCdn1;

    @Column(length = 200)
    private String postCdn2;

    @Column(length = 200)
    private String wgs84Lon;

    @Column(length = 200)
    private String wgs84Lat;

    @OneToMany(mappedBy = "hospital")
    private Set<Booking> hospitalBookings;

    @OneToMany(mappedBy = "hospital")
    private Set<UserMedicalInfo> hospitalUserMedicalInfos;

    @Builder
    public Hospital(Integer id, Boolean isPartner, String name, String rnum, String dutyAddr, String dutyDiv, String dutyDivNam, String dutyEmcls, String dutyEmclsName, String dutyEryn, String dutyEtc, String dutyInf, String dutyMapimg, String dutyName, String dutyTel1, String dutyTel3, String dutyTime1c, String dutyTime2c, String dutyTime3c, String dutyTime4c, String dutyTime5c, String dutyTime6c, String dutyTime7c, String dutyTime8c, String dutyTime1s, String dutyTime2s, String dutyTime3s, String dutyTime4s, String dutyTime5s, String dutyTime6s, String dutyTime7s, String dutyTime8s, String hpid, String postCdn1, String postCdn2, String wgs84Lon, String wgs84Lat, Set<Booking> hospitalBookings, Set<UserMedicalInfo> hospitalUserMedicalInfos) {
        this.id = id;
        this.isPartner = isPartner;
        this.name = name;
        this.rnum = rnum;
        this.dutyAddr = dutyAddr;
        this.dutyDiv = dutyDiv;
        this.dutyDivNam = dutyDivNam;
        this.dutyEmcls = dutyEmcls;
        this.dutyEmclsName = dutyEmclsName;
        this.dutyEryn = dutyEryn;
        this.dutyEtc = dutyEtc;
        this.dutyInf = dutyInf;
        this.dutyMapimg = dutyMapimg;
        this.dutyName = dutyName;
        this.dutyTel1 = dutyTel1;
        this.dutyTel3 = dutyTel3;
        this.dutyTime1c = dutyTime1c;
        this.dutyTime2c = dutyTime2c;
        this.dutyTime3c = dutyTime3c;
        this.dutyTime4c = dutyTime4c;
        this.dutyTime5c = dutyTime5c;
        this.dutyTime6c = dutyTime6c;
        this.dutyTime7c = dutyTime7c;
        this.dutyTime8c = dutyTime8c;
        this.dutyTime1s = dutyTime1s;
        this.dutyTime2s = dutyTime2s;
        this.dutyTime3s = dutyTime3s;
        this.dutyTime4s = dutyTime4s;
        this.dutyTime5s = dutyTime5s;
        this.dutyTime6s = dutyTime6s;
        this.dutyTime7s = dutyTime7s;
        this.dutyTime8s = dutyTime8s;
        this.hpid = hpid;
        this.postCdn1 = postCdn1;
        this.postCdn2 = postCdn2;
        this.wgs84Lon = wgs84Lon;
        this.wgs84Lat = wgs84Lat;
        this.hospitalBookings = hospitalBookings;
        this.hospitalUserMedicalInfos = hospitalUserMedicalInfos;
    }
}
