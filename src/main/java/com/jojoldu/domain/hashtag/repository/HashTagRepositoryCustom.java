package com.jojoldu.domain.hashtag.repository;

import com.jojoldu.domain.course.Course;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface HashTagRepositoryCustom {

    List<Course> findAllCourseByNameLike(String tagName);
}
