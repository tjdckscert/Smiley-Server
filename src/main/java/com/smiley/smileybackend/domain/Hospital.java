package com.smiley.smileybackend.domain;


import com.smiley.smileybackend.domain.keys.Hospitalkeys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(Hospitalkeys.class)
public class Hospital {
    /*
     *국립중앙의료원 국립중앙의료원 전국 병·의원 찾기 서비스 API 사용
     */

    @Id
    private Boolean isPartner;

    /*기관ID*/
    @Id
    private String hPid;

    /*주소*/
    @Column
    private String dutyAddr;

    /*병원분류*/
    @Column
    private String dutyDiv;

    /*병원분류명*/
    @Column
    private String dutyDivNam;

    /*응급의료기관코드*/
    @Column
    private String dutyEmcls;

    /*응급의료기관코드명*/
    @Column
    private String dutyEmclsName;

    /*응급실운영여부(1/2)*/
    @Column
    private String dutyEryn;

    /*비고*/
    @Column
    private String dutyEtc;

    /*기관설명상세*/
    @Column
    private String dutyInf;

    /*건이약도*/
    @Column
    private String dutyMapimg;

    /*기관명*/
    @Column
    private String dutyName;

    /*대표전화번호*/
    @Column
    private String dutyTel1;

    /*응급실전화번호*/
    @Column
    private String dutyTel3;

    /*진료시간(월요일)종료시간*/
    @Column
    private String dutyTime1c;

    /*진료시간(화요일)종료시간*/
    @Column
    private String dutyTime2c;

    /*진료시간(수요일)종료시간*/
    @Column
    private String dutyTime3c;

    /*진료시간(목요일)종료시간*/
    @Column
    private String dutyTime4c;

    /*진료시간(금요일)종료시간*/
    @Column
    private String dutyTime5c;

    /*진료시간(토요일)종료시간*/
    @Column
    private String dutyTime6c;

    /*진료시간(일요일)종료시간*/
    @Column
    private String dutyTime7c;

    /*진료시간(공휴일)종료시간*/
    @Column
    private String dutyTime8c;

    /*진료시간(월요일)시작시간*/
    @Column
    private String dutyTime1s;

    /*진료시간(화요일)시작시간*/
    @Column
    private String dutyTime2s;

    /*진료시간(수요일)시작시간*/
    @Column
    private String dutyTime3s;

    /*진료시간(목요일)시작시간*/
    @Column
    private String dutyTime4s;

    /*진료시간(금요일)시작시간*/
    @Column
    private String dutyTime5s;

    /*진료시간(토요일)시작시간*/
    @Column
    private String dutyTime6s;

    /*진료시간(일요일)시작시간*/
    @Column
    private String dutyTime7s;

    /*진료시간(공휴일)시작시간*/
    @Column
    private String dutyTime8s;


    /*우편번호1*/
    @Column
    private String postCdn1;

    /*우편번호2*/
    @Column
    private String postCdn2;

    /*병원경도*/
    @Column(length = 200)
    private String wgs84Lon;

    /*병원위도*/
    @Column
    private String wgs84Lat;

    @OneToMany(mappedBy = "hospital", orphanRemoval = true)
    private List<Booking> hospitalBookings;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST)
    private List<UserMedicalInfo> userMedicalInfos;

    @Builder
    public Hospital(Boolean isPartner, String hPid, String dutyAddr, String dutyDiv, String dutyDivNam, String dutyEmcls, String dutyEmclsName, String dutyEryn, String dutyEtc, String dutyInf, String dutyMapimg, String dutyName, String dutyTel1, String dutyTel3, String dutyTime1c, String dutyTime2c, String dutyTime3c, String dutyTime4c, String dutyTime5c, String dutyTime6c, String dutyTime7c, String dutyTime8c, String dutyTime1s, String dutyTime2s, String dutyTime3s, String dutyTime4s, String dutyTime5s, String dutyTime6s, String dutyTime7s, String dutyTime8s, String postCdn1, String postCdn2, String wgs84Lon, String wgs84Lat, List<Booking> hospitalBookings, List<UserMedicalInfo> userMedicalInfos) {
        this.isPartner = isPartner;
        this.hPid = hPid;
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
        this.postCdn1 = postCdn1;
        this.postCdn2 = postCdn2;
        this.wgs84Lon = wgs84Lon;
        this.wgs84Lat = wgs84Lat;
        this.hospitalBookings = hospitalBookings;
        this.userMedicalInfos = userMedicalInfos;
    }

    public static Hospital jsonToEntity(JSONObject jsonObject) {
        return Hospital.builder()
                .isPartner(false)
                .hPid(jsonObject.optString("hpid"))
                .dutyAddr(jsonObject.optString("dutyAddr"))
                .dutyDiv(jsonObject.optString("dutyDiv"))
                .dutyDivNam(jsonObject.optString("dutyDivNam"))
                .dutyEmcls(jsonObject.optString("dutyEmcls"))
                .dutyEmclsName(jsonObject.optString("dutyEmclsName"))
                .dutyEryn(jsonObject.optString("dutyEryn"))
                .dutyEtc(jsonObject.optString("dutyEtc"))
                .dutyInf(jsonObject.optString("dutyInf"))
                .dutyMapimg(jsonObject.optString("dutyMapimg"))
                .dutyName(jsonObject.optString("dutyName"))
                .dutyTel1(jsonObject.optString("dutyTel1"))
                .dutyTel3(jsonObject.optString("dutyTel3"))
                .dutyTime1c(jsonObject.optString("dutyTime1c"))
                .dutyTime2c(jsonObject.optString("dutyTime2c"))
                .dutyTime3c(jsonObject.optString("dutyTime3c"))
                .dutyTime4c(jsonObject.optString("dutyTime4c"))
                .dutyTime5c(jsonObject.optString("dutyTime5c"))
                .dutyTime6c(jsonObject.optString("dutyTime6c"))
                .dutyTime7c(jsonObject.optString("dutyTime7c"))
                .dutyTime8c(jsonObject.optString("dutyTime8c"))
                .dutyTime1s(jsonObject.optString("dutyTime1s"))
                .dutyTime2s(jsonObject.optString("dutyTime2s"))
                .dutyTime3s(jsonObject.optString("dutyTime3s"))
                .dutyTime4s(jsonObject.optString("dutyTime4s"))
                .dutyTime5s(jsonObject.optString("dutyTime5s"))
                .dutyTime6s(jsonObject.optString("dutyTime6s"))
                .dutyTime7s(jsonObject.optString("dutyTime7s"))
                .dutyTime8s(jsonObject.optString("dutyTime8s"))
                .postCdn1(jsonObject.optString("postCdn1"))
                .postCdn2(jsonObject.optString("postCdn2"))
                .wgs84Lon(jsonObject.optString("wgs84Lon"))
                .wgs84Lat(jsonObject.optString("wgs84Lat")).build();
    }
}
