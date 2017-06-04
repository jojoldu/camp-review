package com.jojoldu.domain.course.repository;

import com.jojoldu.domain.course.Course;
import com.jojoldu.domain.course.Teacher;
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

    @After
    public void cleanAll () {
        courseRepository.deleteAll();
    }

    @Test
    @Transactional
    public void course를_가져오면_teacher도_가져온다 () throws Exception {
        //given
        Teacher teacher = teacherRepository.save(Teacher.builder().name("창천향로").build());
        Course course = courseRepository.save(Course.builder()
                .type(Course.Type.WEB)
                .title("자바웹캠프")
                .description("자바 과정")
                .build());

        //when
        course.addTeacher(teacher);
        Course savedCourse = courseRepository.findAll().get(0);

        //then
        assertThat(savedCourse.getTeachers().size(), is(1));
    }
}
