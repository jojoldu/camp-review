package com.jojoldu.domain.hashtag.repository;

import com.jojoldu.domain.course.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashTagRepositoryTest {

    @Autowired
    private HashTagRepository hashTagRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void HashTag의_name으로_Course를_조회한다 () throws Exception {

    }
}
