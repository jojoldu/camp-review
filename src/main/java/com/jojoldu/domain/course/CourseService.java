package com.jojoldu.domain.course;

import com.jojoldu.domain.course.repository.CourseRepository;
import com.jojoldu.domain.hashtag.HashTag;
import com.jojoldu.domain.hashtag.repository.HashTagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 9.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private HashTagRepository hashTagRepository;

    public CourseService(CourseRepository courseRepository, HashTagRepository hashTagRepository) {
        this.courseRepository = courseRepository;
        this.hashTagRepository = hashTagRepository;
    }

    @Transactional
    public void saveCourseAndHashTag(Course course, List<String> hashTagNames){
        for(String tagName : hashTagNames){
            saveHashTag(course, tagName);
        }

        courseRepository.save(course);
    }

    private void saveHashTag(Course course, String tagName) {
        if(hashTagRepository.countByName(tagName).equals(0L)){
            HashTag hashTag = hashTagRepository.save(new HashTag(tagName));
            course.addHashTag(hashTag);
        }
    }

}
