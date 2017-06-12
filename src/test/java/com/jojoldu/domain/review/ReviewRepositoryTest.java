package com.jojoldu.domain.review;

import com.jojoldu.domain.course.Course;
import com.jojoldu.domain.course.Teacher;
import com.jojoldu.domain.course.repository.CourseRepository;
import com.jojoldu.domain.course.repository.TeacherRepository;
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
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @After
    public void cleanAll () {
        reviewRepository.deleteAll();
        teacherRepository.deleteAll();
    }

    @Test
    @Transactional
    public void course를_가져오면_teacher도_가져온다 () throws Exception {
        //given
        Teacher teacher = teacherRepository.save(Teacher.builder().name("창천향로").build());
        Review review = reviewRepository.save(new Review(1L, "내용"));

        //when
        review.addTeacher(teacher);
        Review savedReview = reviewRepository.findAll().get(0);

        //then
        assertThat(savedReview.getTeachers().size(), is(1));
    }
}
