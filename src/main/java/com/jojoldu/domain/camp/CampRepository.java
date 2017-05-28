package com.jojoldu.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface CampRepository extends JpaRepository<Camp, Long>, CampRepositoryCustom{
}
