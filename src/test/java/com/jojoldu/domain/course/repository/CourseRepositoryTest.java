package com.jojoldu.domain.course.repository;

import com.jojoldu.domain.course.Course;
import com.jojoldu.domain.course.Teacher;
import com.jojoldu.domain.course.type.CourseType;
import com.jojoldu.domain.review.Review;
import com.jojoldu.domain.review.ReviewRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 31.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @After
    public void cleanAll () {
        reviewRepository.deleteAll();
        teacherRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @Test
    @Transactional
    public void Course조회하면_review가_조회된다() throws Exception {
        //given
        Course course = courseRepository.save(Course.builder()
                .type(CourseType.WEB)
                .title("자바웹캠프")
                .description("자바 과정")
                .build());

        Review review = reviewRepository.save(new Review(4.5, "최고에요"));

        //when
        course.addReview(review);
        Course savedCourse = courseRepository.findAll().get(0);

        //then
        assertThat(savedCourse.getReviews().size(), is(1));
        assertThat(savedCourse.getReviews().get(0).getStar(), is(4.5));



    }
}
