package com.jojoldu.domain.course;

import com.jojoldu.common.EnumType;
import com.jojoldu.domain.camp.Camp;
import com.jojoldu.domain.common.BaseEntity;
import com.jojoldu.domain.review.Review;
import lombok.Builder;
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
public class Course extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Enumerated(javax.persistence.EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", foreignKey = @ForeignKey(name = "FK_COURSE_CAMP"))
    private Camp camp;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseTeacherMap> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Course(Type type, String title, String description, String imageUrl, Camp camp) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.camp = camp;
    }

    public void addTeachers(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            addTeacher(teacher);
        }
    }

    public void addTeacher(Teacher teacher){
        teachers.add(new CourseTeacherMap(this, teacher));
    }

    public void addReviews(List<Review> reviews){
        for (Review review : reviews) {
            addReview(review);
        }
    }

    public void addReview(Review review) {
        reviews.add(review);
        review.updateCourse(this);
    }

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
