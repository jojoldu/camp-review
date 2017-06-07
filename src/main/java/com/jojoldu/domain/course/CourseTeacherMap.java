package com.jojoldu.domain.course;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class CourseTeacherMap {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "FK_COURSE_TEACHER_MAP_COURSE"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "FK_COURSE_TEACHER_MAP_TEACHER"))
    private Teacher teacher;

    public CourseTeacherMap(Course course, Teacher teacher) {
        this.course = course;
        this.teacher = teacher;
    }
}
