package com.jojoldu.domain.course;

import com.jojoldu.common.EnumType;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 29.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public enum Language implements EnumType{
    SHELL_SCRIPT("쉘스크립트"),
    C("C/C++"),
    JAVA("JAVA"),
    PYTHON("Python"),
    NODE("NodeJS"),
    RUBY("Ruby"),
    JAVASCRIPT("Javascript"),
    MARKUP("HTML/CSS"),
    KOTLIN("Kotlin");

    private String title;

    Language(String title) {
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
