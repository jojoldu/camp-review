package com.jojoldu.domain.hashtag;

import com.jojoldu.domain.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 7.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "UNI_HASH_TAG_NAME", columnNames = {"name"})
        }
)
public class HashTag extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public HashTag(String name) {
        this.name = name;
    }

}
