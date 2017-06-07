package com.jojoldu.domain.hashtag.repository;

import com.jojoldu.domain.hashtag.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 8.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface HashTagRepository extends JpaRepository<HashTag, Long>, HashTagRepositoryCustom {
}
