package com.jojoldu.oauth.domain;

import com.jojoldu.domain.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 5.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */
@NoArgsConstructor
@Getter
@Entity
@Table(
        uniqueConstraints = {
            @UniqueConstraint(name = "UNI_MEMBER_EMAIL", columnNames = {"email"})
        }
)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;
}
