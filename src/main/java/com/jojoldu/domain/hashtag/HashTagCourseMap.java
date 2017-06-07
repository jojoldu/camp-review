package com.jojoldu.domain.hashtag;

import com.jojoldu.domain.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 7.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class HashTagCourseMap {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "FK_HASH_TAG_COURSE_MAP_COURSE"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "hashtag_id", foreignKey = @ForeignKey(name = "FK_HASH_TAG_COURSE_MAP_HASH_TAG"))
    private HashTag hashTag;

    public HashTagCourseMap(Course course, HashTag hashTag) {
        this.course = course;
        this.hashTag = hashTag;
    }
}
