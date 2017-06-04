package com.jojoldu.domain.course;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 31.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
@Table(
        uniqueConstraints = {
            @UniqueConstraint(name = "UNI_TEACHER_NAME", columnNames = {"name"})
        }
)
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String profile;

    @Column
    private String imageUrl;

    @Builder
    public Teacher(String name, String profile, String imageUrl) {
        this.name = name;
        this.profile = profile;
        this.imageUrl = imageUrl;
    }
}
