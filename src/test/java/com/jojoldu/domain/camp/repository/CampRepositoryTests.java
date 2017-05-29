package com.jojoldu.domain.camp.repository;

import com.jojoldu.domain.camp.Address;
import com.jojoldu.domain.camp.Camp;
import com.jojoldu.domain.camp.repository.CampRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

    @After
    public void cleanAll() {
        campRepository.deleteAll();
    }

    @Test
    public void camp조회() throws Exception {
        //given
        campRepository.save(Camp.builder().name("강남학원").build());

        //when
        Camp camp = campRepository.findAll().get(0);

        //then
        assertThat(camp.getName(), is("강남학원"));
    }

    @Test
    public void querydsl로_camp_이름_like조회() throws Exception {
        //given
        campRepository.save(Camp.builder().name("강남학원").build());
        campRepository.save(Camp.builder().name("판교학원").build());

        //when
        List<Camp> camps = campRepository.findAllLikeName("강남");

        //then
        assertThat(camps.size(), is(1));
        assertThat(camps.get(0).getName(), is("강남학원"));
    }

    @Test
    @Transactional
    public void camp조회시_주소도_같이조회된다() throws Exception {
        //give
        Camp camp = Camp.builder()
                .name("강남학원")
                .build();
        Address address = new Address("강남구 청담동");
        camp.addAddress(address);
        campRepository.save(camp);

        //when
        List<Camp> camps = campRepository.findAllLikeName("강남");

        //then
        assertThat(camps.size(), is(1));
        assertThat(camps.get(0).getName(), is("강남학원"));
        assertThat(camps.get(0).getAddressList().size(), is(1));
        assertThat(camps.get(0).getAddressList().get(0).getContent(), is("강남구 청담동"));
    }
}
