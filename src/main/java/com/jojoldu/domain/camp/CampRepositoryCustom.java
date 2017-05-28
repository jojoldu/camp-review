package com.jojoldu.domain.camp;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface CampRepositoryCustom {
    List<Camp> findAllLikeName(String name);
}
