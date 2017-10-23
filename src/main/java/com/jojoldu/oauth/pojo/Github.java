package com.jojoldu.oauth.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jojoldu.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 5.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Github {

    @JsonProperty("login")
    private String name;
    private String email;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public Member createMember() {
        return Member.builder()
                .name(name)
                .email(email)
                .avatarUrl(avatarUrl)
                .build();
    }

    public void updateMember(Member member){
        member.update(
                name,
                email,
                avatarUrl
        );
    }
}
