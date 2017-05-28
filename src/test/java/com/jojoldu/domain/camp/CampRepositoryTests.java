package com.jojoldu.domain.camp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampRepositoryTests {

    @Autowired
    private CampRepository campRepository;


    @Test
    public void camp조회() throws Exception {
        //given
        campRepository.save(Camp.builder().name("강남학원").address("강남").build());

        //when
        Camp camp = campRepository.findOne(1L);

        //then
        assertThat(camp.getName(), is("강남학원"));
    }

    @Test
    public void querydsl로_camp_이름_like조회() throws Exception {
        //given
        campRepository.save(Camp.builder().name("강남학원").address("강남").build());
        campRepository.save(Camp.builder().name("판교학원").address("판교").build());

        //when
        List<Camp> camps = campRepository.findAllLikeName("강남");

        //then
        assertThat(camps.size(), is(1));
        assertThat(camps.get(0).getName(), is("강남학원"));
    }
}
