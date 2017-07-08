package com.jojoldu.domain.course.dto;

import com.jojoldu.domain.course.Course;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 9.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
public class CourseRequestDto {

    @NotBlank(message = "교육센터를 등록해주세요")
    private Long campId;

    @NotBlank(message = "과정명을 등록해주세요")
    private String title;

    @NotBlank(message = "과정형태를 선택해주세요")
    private String type;

    private List<String> teacherNames = new ArrayList<>();

    private List<String> tagNames = new ArrayList<>();

    public void valid(){

    }

}
