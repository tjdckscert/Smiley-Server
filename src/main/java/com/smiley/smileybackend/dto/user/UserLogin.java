package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
    @NotBlank(message = "이메일을 입력해주세요, 공백 X")
    @Email(message = "이메일 형식이 아닙니다.")
    @ApiModelProperty(value = "사용자입력이 Email 형식인지 확인. 공백 X")
    private String email;

    @ApiModelProperty(value = "사용자 휴대폰 토큰값. 공백 X")
    private String phoneToken;

    @NotBlank(message = "이름을 입력해주세요, 공백 X")
    @ApiModelProperty(value = "사용자 이름확인. 공백 X")
    private String name;

    @NotNull(message = "생년월일 입력해주세요, 공백 X")
    @PastOrPresent
    @ApiModelProperty(value = "사용자 생년월일 확인 / 입력 양식은 'yyyy-mm-dd' . 공백 X. NOW보다 과거의 날짜만 가능하다.")
    private LocalDate birthDate;

    public User toEntity() {
        return User.builder()
                .email(email)
                .phoneToken(phoneToken)
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}
