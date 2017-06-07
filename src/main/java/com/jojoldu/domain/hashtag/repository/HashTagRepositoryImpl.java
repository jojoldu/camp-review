package com.jojoldu.domain.hashtag.repository;

import com.jojoldu.domain.course.Course;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.jojoldu.domain.course.QCourse.course;
import static com.jojoldu.domain.hashtag.QHashTag.hashTag;
import static com.jojoldu.domain.hashtag.QHashTagCourseMap.hashTagCourseMap;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class HashTagRepositoryImpl implements HashTagRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public HashTagRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Course> findAllCourseByNameLike(String tagName) {
        return queryFactory
                .select(course)
                .from(hashTagCourseMap)
                .join(hashTagCourseMap.course, course)
                .join(hashTagCourseMap.hashTag, hashTag)
                .where(likeName(tagName))
                .fetch();
    }

    private BooleanExpression likeName(String tagName){
        if(StringUtils.isEmpty(tagName)){
            return null;
        }

        return hashTag.name.like("%"+tagName+"%");
    }
}
