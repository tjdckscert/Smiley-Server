package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.user.SurveyJson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.List;

@Getter
@Slf4j
@ToString
@NoArgsConstructor
public class UserMedicalInfoSave {
    private Integer id;
    private Integer calibrationStatus;
    private LocalDate startDate;
    private List<SurveyJson> surveyResult;

    public UserMedicalInfoSave(UserMedicalInfo saved) {
        this.id = saved.getId();
        this.calibrationStatus = saved.getCalibrationStatus();
        this.startDate = saved.getStartDate();
        this.surveyResult = saved.getSurveyResult();
    }


}
