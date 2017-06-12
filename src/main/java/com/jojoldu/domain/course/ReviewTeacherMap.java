package com.jojoldu.domain.course;

import com.jojoldu.domain.review.Review;
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
public class ReviewTeacherMap {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(name = "FK_REVIEW_TEACHER_MAP_REVIEW"))
    private Review review;

    @ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "FK_REVIEW_TEACHER_MAP_TEACHER"))
    private Teacher teacher;

    public ReviewTeacherMap(Review review, Teacher teacher) {
        this.review = review;
        this.teacher = teacher;
    }
}
