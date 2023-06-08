package com.smiley.smileybackend.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.security.SecureRandom;

@Getter
@ToString
public class TestDateDto {
    @ApiModelProperty( example = "당일 착용 시간(분 단위)")
    private int wearTime;

    @ApiModelProperty( example = "당일 읽은 매거진 수")
    private int readMagazineNumber;

    @ApiModelProperty( example = "획득 경험치(전체)")
    private int totalExp;

    @ApiModelProperty( example = "획득 경험치(일일 착용 시간)")
    private int totalWearTimeExp;

    @ApiModelProperty( example = "획득 경험치(목표 착용 시간)")
    private int targetWearTimeEXP;

    @ApiModelProperty( example = "획득 경험치(매거진 읽기)")
    private int magazineExp;

    @ApiModelProperty( example = "획득 경험치(뱃지 획득)")
    private int badgeExp;

    @ApiModelProperty( example = "획득 경험치(댓글 채택)")
    private int commentExp;

    @Builder
    public TestDateDto(int wearTime, int readMagazineNumber, int totalExp, int totalWearTimeExp, int targetWearTimeEXP, int magazineExp, int badgeExp, int commentExp) {
        this.wearTime = wearTime;
        this.readMagazineNumber = readMagazineNumber;
        this.totalExp = totalExp;
        this.totalWearTimeExp = totalWearTimeExp;
        this.targetWearTimeEXP = targetWearTimeEXP;
        this.magazineExp = magazineExp;
        this.badgeExp = badgeExp;
        this.commentExp=commentExp;
    }

    public TestDateDto() {
        SecureRandom random = new SecureRandom ();
        this.wearTime = random.nextInt(760)+200;
        this.readMagazineNumber = random.nextInt(3);
        this.totalWearTimeExp = random.nextInt(16000)*5;
        this.targetWearTimeEXP = random.nextInt(11000);
        this.magazineExp = random.nextInt(12)*100;
        this.badgeExp = random.nextInt(14)*1000;
        this.commentExp=random.nextInt(20)*500;
        this.totalExp = this.totalWearTimeExp+this.targetWearTimeEXP+this.magazineExp+this.badgeExp;
    }
}
