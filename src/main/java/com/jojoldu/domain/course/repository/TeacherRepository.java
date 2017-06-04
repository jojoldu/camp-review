package com.jojoldu.domain.course.repository;

import com.jojoldu.domain.course.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    Optional<Teacher> findByName(String name);
}
