package com.jojoldu.domain.course;

import com.jojoldu.domain.camp.Camp;
import com.jojoldu.domain.common.BaseEntity;
import com.jojoldu.domain.course.type.CourseType;
import com.jojoldu.domain.hashtag.HashTag;
import com.jojoldu.domain.hashtag.HashTagCourseMap;
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
    @Enumerated(EnumType.STRING)
    private CourseType type;

    @Column(nullable = false)
    private String title; // Camp와 title을 조합하여 유니크한지 체크가 필요

    private String description;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", foreignKey = @ForeignKey(name = "FK_COURSE_CAMP"))
    private Camp camp;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<HashTagCourseMap> hashTags = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Course(CourseType type, String title, String description, String imageUrl, Camp camp) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.camp = camp;
    }

    public void addHashTag(HashTag hashTag){
        hashTags.add(new HashTagCourseMap(this, hashTag));
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

}
