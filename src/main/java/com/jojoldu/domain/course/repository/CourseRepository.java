package com.jojoldu.domain.course.repository;

import com.jojoldu.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 31.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface CourseRepository extends JpaRepository<Course, Long>{
}
