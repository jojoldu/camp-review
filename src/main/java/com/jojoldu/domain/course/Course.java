package com.jojoldu.domain.course;

import com.jojoldu.domain.camp.Camp;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;



    @ManyToOne
    @JoinColumn(name = "camp_id", foreignKey = @ForeignKey(name = "FK_COURSE_CAMP"))
    private Camp camp;

}
