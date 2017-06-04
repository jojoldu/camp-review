package com.jojoldu.domain.review;

import com.jojoldu.domain.common.BaseEntity;
import com.jojoldu.domain.course.Course;
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

    public Review(double star, String content) {
        this.star = star;
        this.content = content;
    }

    public void updateCourse(Course course){
        this.course = course;
    }
}
