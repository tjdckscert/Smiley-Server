package com.smiley.smileybackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
@Slf4j
public class AchievementAspect {

    @After("@annotation(com.smiley.smileybackend.annotation.WearTimeAchievementsAnnotation)")
    public void AchievementsAnnotation(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object[] objects = joinPoint.getArgs();
        Field field=objects[0].getClass().getDeclaredField("userId"); //필드 지정
        field.setAccessible(true); //private 접근 가능
        String userId = (String) field.get(objects[0]); // DailyWearTimeDTo의 userId값 추출
        log.info("userId = "+userId);
        //Service객체를 통한 정보 조회
    }
}
