package com.smiley.smileybackend._05_hospital.dto;

import com.smiley.smileybackend._05_hospital.domain.Hospital;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class HospitalInfoDto {

    @ApiModelProperty( example = "파트너여부/Boolean")
    private Boolean isPartner;

    @ApiModelProperty( example = "기관ID")
    private String hPid;

    @ApiModelProperty( example = "주소")
    private String dutyAddr;

    @ApiModelProperty( example = "병원분류")
    private String dutyDiv;

    @ApiModelProperty( example = "병원분류명")
    private String dutyDivNam;

    @ApiModelProperty( example = "응급의료기관코드")
    private String dutyEmcls;

    @ApiModelProperty( example = "응급의료기관코드명")
    private String dutyEmclsName;

    @ApiModelProperty( example = "응급실운영여부(1/2)")
    private String dutyEryn;

    @ApiModelProperty( example = "비고")
    private String dutyEtc;

    @ApiModelProperty( example = "기관설명상세")
    private String dutyInf;

    @ApiModelProperty( example = "건이약도")
    private String dutyMapimg;

    @ApiModelProperty( example = "기관명")
    private String dutyName;

    @ApiModelProperty( example = "대표전화번호")
    private String dutyTel1;

    @ApiModelProperty( example = "응급실전화번호")
    private String dutyTel3;

    @ApiModelProperty( example = "진료시간(월요일)종료시간")
    private String dutyTime1c;

    @ApiModelProperty( example = "진료시간(화요일)종료시간")
    private String dutyTime2c;

    @ApiModelProperty( example = "진료시간(수요일)종료시간")
    private String dutyTime3c;

    @ApiModelProperty( example = "진료시간(목요일)종료시간")
    private String dutyTime4c;

    @ApiModelProperty( example = "진료시간(금요일)종료시간")
    /*진료시간(금요일)종료시간*/
    private String dutyTime5c;

    @ApiModelProperty( example = "진료시간(토요일)종료시간")
    private String dutyTime6c;

    @ApiModelProperty( example = "진료시간(일요일)종료시간")
    private String dutyTime7c;

    @ApiModelProperty( example = "진료시간(공휴일)종료시간")
    private String dutyTime8c;

    @ApiModelProperty( example = "진료시간(월요일)시작시간")
    private String dutyTime1s;

    @ApiModelProperty( example = "진료시간(화요일)시작시간")
    private String dutyTime2s;

    @ApiModelProperty( example = "진료시간(수요일)시작시간")
    private String dutyTime3s;

    @ApiModelProperty( example = "진료시간(목요일)시작시간")
    private String dutyTime4s;

    @ApiModelProperty( example = "진료시간(금요일)시작시간")
    private String dutyTime5s;

    @ApiModelProperty( example = "진료시간(토요일)시작시간")
    private String dutyTime6s;

    @ApiModelProperty( example = "진료시간(일요일)시작시간")
    private String dutyTime7s;

    @ApiModelProperty( example = "진료시간(공휴일)시작시간")
    private String dutyTime8s;

    @ApiModelProperty( example = "우편번호1")
    private String postCdn1;

    @ApiModelProperty( example = "우편번호2")
    private String postCdn2;

    @ApiModelProperty( example = "병원경도")
    private String wgs84Lon;

    @ApiModelProperty( example = "병원위도")
    private String wgs84Lat;


    @Builder
    public HospitalInfoDto(Hospital saved) {
        this.isPartner = saved.getIsPartner();
        this.hPid = saved.getHPid();
        this.dutyAddr = saved.getDutyAddr();
        this.dutyDiv = saved.getDutyDiv();
        this.dutyDivNam = saved.getDutyDivNam();
        this.dutyEmcls = saved.getDutyEmcls();
        this.dutyEmclsName = saved.getDutyEmclsName();
        this.dutyEryn = saved.getDutyEryn();
        this.dutyEtc = saved.getDutyEtc();
        this.dutyInf = saved.getDutyInf();
        this.dutyMapimg = saved.getDutyMapimg();
        this.dutyName = saved.getDutyName();
        this.dutyTel1 = saved.getDutyTel1();
        this.dutyTel3 = saved.getDutyTel3();
        this.dutyTime1c = saved.getDutyTime1c();
        this.dutyTime2c = saved.getDutyTime2c();
        this.dutyTime3c = saved.getDutyTime3c();
        this.dutyTime4c = saved.getDutyTime4c();
        this.dutyTime5c = saved.getDutyTime5c();
        this.dutyTime6c = saved.getDutyTime6c();
        this.dutyTime7c = saved.getDutyTime7c();
        this.dutyTime8c = saved.getDutyTime8c();
        this.dutyTime1s = saved.getDutyTime1s();
        this.dutyTime2s = saved.getDutyTime2s();
        this.dutyTime3s = saved.getDutyTime3s();
        this.dutyTime4s = saved.getDutyTime4s();
        this.dutyTime5s = saved.getDutyTime5s();
        this.dutyTime6s = saved.getDutyTime6s();
        this.dutyTime7s = saved.getDutyTime7s();
        this.dutyTime8s = saved.getDutyTime8s();
        this.postCdn1 = saved.getPostCdn1();
        this.postCdn2 = saved.getPostCdn2();
        this.wgs84Lon = saved.getWgs84Lon();
        this.wgs84Lat = saved.getWgs84Lat();
    }

    @Builder
    public HospitalInfoDto(Boolean isPartner, String hPid, String dutyAddr, String dutyDiv, String dutyDivNam, String dutyEmcls, String dutyEmclsName, String dutyEryn, String dutyEtc, String dutyInf, String dutyMapimg, String dutyName, String dutyTel1, String dutyTel3, String dutyTime1c, String dutyTime2c, String dutyTime3c, String dutyTime4c, String dutyTime5c, String dutyTime6c, String dutyTime7c, String dutyTime8c, String dutyTime1s, String dutyTime2s, String dutyTime3s, String dutyTime4s, String dutyTime5s, String dutyTime6s, String dutyTime7s, String dutyTime8s, String postCdn1, String postCdn2, String wgs84Lon, String wgs84Lat) {
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
    }

    @Builder
    public static HospitalInfoDto entityToDto(Hospital hospital){
        return new HospitalInfoDto(
          hospital.getIsPartner(),
          hospital.getHPid(),
          hospital.getDutyAddr(),
          hospital.getDutyDiv(),
          hospital.getDutyDivNam(),
          hospital.getDutyEmcls(),
          hospital.getDutyEmclsName(),
          hospital.getDutyEryn(),
          hospital.getDutyEtc(),
          hospital.getDutyInf(),
          hospital.getDutyMapimg(),
          hospital.getDutyName(),
          hospital.getDutyTel1(),
          hospital.getDutyTel3(),
          hospital.getDutyTime1c(),
          hospital.getDutyTime2c(),
          hospital.getDutyTime3c(),
          hospital.getDutyTime4c(),
          hospital.getDutyTime5c(),
          hospital.getDutyTime6c(),
          hospital.getDutyTime7c(),
          hospital.getDutyTime8c(),
          hospital.getDutyTime1s(),
          hospital.getDutyTime2s(),
          hospital.getDutyTime3s(),
          hospital.getDutyTime4s(),
          hospital.getDutyTime5s(),
          hospital.getDutyTime6s(),
          hospital.getDutyTime7s(),
          hospital.getDutyTime8s(),
          hospital.getPostCdn1(),
          hospital.getPostCdn2(),
          hospital.getWgs84Lon(),
          hospital.getWgs84Lat()
          );
    }
}
