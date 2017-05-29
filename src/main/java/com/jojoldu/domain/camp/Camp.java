package com.jojoldu.domain.camp;

import com.jojoldu.domain.course.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
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

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @OneToMany(mappedBy = "camp", cascade = ALL, orphanRemoval = true)
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "camp", cascade = ALL)
    private List<Course> courses = new ArrayList<>();

    @Builder
    public Camp(String name, String phoneNumber, String email, List<Address> addressList, List<Course> courses) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressList = addressList;
        this.courses = courses;
    }

    public void addAddress(Address address){
        if(addressList == null){
            addressList = new ArrayList<>();
        }
        addressList.add(address);
        address.setCamp(this);
    }
}
