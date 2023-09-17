package com.smiley.smileybackend._01_user.dto.user;

import com.smiley.smileybackend._01_user.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class UserLoginDto {
    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @ApiModelProperty(value = "사용자 휴대폰 토큰값. 공백 X")
    private String phoneToken;

    @NotBlank(message = "이름을 입력해주세요, 공백 X")
    @ApiModelProperty(value = "사용자 이름확인. 공백 X")
    private String name;

    @NotNull(message = "생년월일 입력해주세요, 공백 X")
    @PastOrPresent
    @ApiModelProperty(value = "사용자 생년월일 확인 / 입력 양식은 'yyyy-mm-dd' . 공백 X. NOW보다 과거의 날짜만 가능하다.")
    private LocalDate birthDate;

    @Builder
    public UserLoginDto(String userNumber, String phoneToken, String name, LocalDate birthDate) {
        this.userNumber = userNumber;
        this.phoneToken = phoneToken;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User toEntity() {
        return User.builder()
                .userNumber(userNumber)
                .phoneToken(phoneToken)
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}
