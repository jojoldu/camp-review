package com.jojoldu.domain.review;

import com.jojoldu.domain.common.BaseEntity;
import com.jojoldu.domain.course.Course;
import com.jojoldu.domain.course.ReviewTeacherMap;
import com.jojoldu.domain.course.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class Review extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double star;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "FK_REVIEW_COURSE"))
    private Course course;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewTeacherMap> teachers = new ArrayList<>();

    public Review(double star, String content) {
        this.star = star;
        this.content = content;
    }

    public void addTeachers(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            addTeacher(teacher);
        }
    }

    public void addTeacher(Teacher teacher){
        teachers.add(new ReviewTeacherMap(this, teacher));
    }

    public void updateCourse(Course course){
        this.course = course;
    }
}
