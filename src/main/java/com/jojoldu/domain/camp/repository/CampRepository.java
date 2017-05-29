package com.jojoldu.domain.camp.repository;

import com.jojoldu.domain.camp.Camp;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

import static com.jojoldu.domain.camp.QCamp.camp;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public interface CampRepository extends JpaRepository<Camp, Long>, CampRepositoryCustom {

    List<Camp> findAllByNameContainingIgnoreCase(String name);
}
