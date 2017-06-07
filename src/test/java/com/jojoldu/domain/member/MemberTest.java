package com.jojoldu.domain.member;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 7.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @After
    public void cleanAll (){
        memberRepository.deleteAll();
    }

    @Test
    public void 자동으로_createDate와_updateDate를_추가한다() throws Exception {
        //given
        Member member = Member.builder()
                .githubName("jojoldu")
                .email("jojoldu@gmail.com")
                .avatarUrl("http://jojoldu.tistory.com")
                .build();

        memberRepository.save(member);

        Member savedMember = memberRepository.findOne(1L);
        assertTrue(savedMember.getCreatedDate().isAfter(LocalDateTime.of(1970, 1, 1, 0, 0)));
    }
}
