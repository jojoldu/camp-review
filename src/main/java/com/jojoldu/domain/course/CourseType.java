package com.jojoldu.domain.course;

import com.jojoldu.common.EnumType;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 30.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public enum CourseType implements EnumType{
    WEB("웹 개발"),
    APP("앱 개발"),
    GAME("게임 개발"),
    LANGUAGE("프로그래밍 언어"),
    ENGINEERING("엔지니어링"),
    TOOLS("개발 도구");

    private String title;

    CourseType(String title) {
        this.title = title;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
