package com.jojoldu.domain.teacher;

import com.jojoldu.domain.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 31.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String profile;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name="FK_TEACHER_COURSE"))
    private Course course;

}
