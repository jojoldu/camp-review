package com.jojoldu.domain.camp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Getter
@NoArgsConstructor
@Entity
public class Camp {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private String phoneNumber;

    @Builder
    public Camp(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
