package com.jojoldu.domain.course;

import com.jojoldu.domain.course.repository.CourseRepository;
import com.jojoldu.domain.hashtag.repository.HashTagRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {

    @Autowired
    private HashTagRepository hashTagRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @After
    public void cleanAll() {
        courseRepository.deleteAll();
        hashTagRepository.deleteAll();
    }

    @Test
    public void HashTag의_name으로_Course를_조회한다() throws Exception {
        //given
        final String title = "자바 웹 캠프";
        Course course = Course.builder()
                .title(title)
                .type(Course.Type.WEB)
                .build();

        List<String> tagNames = Arrays.asList("강남", "자바", "웹개발", "스프링");

        //when
        courseService.saveCourseAndHashTag(course, tagNames);
        List<Course> savedCourses = hashTagRepository.findAllCourseByNameLike("강남");

        //then
        assertThat(savedCourses.size()).isEqualTo(1);
        assertThat(savedCourses.get(0).getTitle()).isEqualTo(title);
    }
}
