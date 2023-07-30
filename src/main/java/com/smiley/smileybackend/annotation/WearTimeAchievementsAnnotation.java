package com.smiley.smileybackend.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface WearTimeAchievementsAnnotation {
    int userId() default 0;
    int userWearTime() default 0;
}
