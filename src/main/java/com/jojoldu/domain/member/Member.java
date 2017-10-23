package com.jojoldu.domain.member;

import com.jojoldu.domain.common.BaseEntity;
import lombok.Builder;
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
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String avatarUrl;

    @Builder
    public Member(String name, String email, String avatarUrl) {
        this.name = name;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public void update(String name, String email, String avatarUrl){
        this.name = name;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }
}
