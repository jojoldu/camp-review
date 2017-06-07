package com.jojoldu.domain.camp;

import com.jojoldu.domain.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 29.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Getter
@NoArgsConstructor
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "camp_id", foreignKey = @ForeignKey(name = "FK_ADDRESS_CAMP"))
    private Camp camp;

    public Address(String content) {
        this.content = content;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }
}
