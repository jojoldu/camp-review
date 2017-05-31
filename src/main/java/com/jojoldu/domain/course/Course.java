package com.jojoldu.domain.course;

import com.jojoldu.common.EnumType;
import com.jojoldu.domain.camp.Camp;
import com.jojoldu.domain.teacher.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Enumerated(javax.persistence.EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "camp_id", foreignKey = @ForeignKey(name = "FK_COURSE_CAMP"))
    private Camp camp;

    @OneToMany(mappedBy = "course")
    private List<Teacher> teachers = new ArrayList<>();

    public enum Type implements EnumType {
        WEB("웹 개발"),
        APP("앱 개발"),
        GAME("게임 개발"),
        LANGUAGE("프로그래밍 언어"),
        ENGINEERING("엔지니어링"),
        MACHINE_LEARNING("머신러닝"),
        BIG_DATA("빅데이터"),
        TOOLS("개발 도구");

        private String title;

        Type(String title) {
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
}
