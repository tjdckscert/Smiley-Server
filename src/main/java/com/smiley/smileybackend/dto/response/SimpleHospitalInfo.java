package com.smiley.smileybackend.dto.response;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class SimpleHospitalInfo {
    private Integer id;
    private String name;
    private String dutyAddr;

}
