package com.jojoldu.domain.camp;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.jojoldu.domain.camp.QCamp.camp;

/**
 * Created by jojoldu@gmail.com on 2017. 5. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class CampRepositoryImpl implements CampRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public CampRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Camp> findAllLikeName(String name) {
        return queryFactory
                .select(Projections.fields(
                        Camp.class,
                        camp.name,
                        camp.address,
                        camp.phoneNumber
                ))
                .from(camp)
                .where(likeName(name))
                .fetch();
    }

    private BooleanExpression likeName(String name){
        if(name == null){
            return null;
        }

        return camp.name.like("%"+name+"%");
    }
}
