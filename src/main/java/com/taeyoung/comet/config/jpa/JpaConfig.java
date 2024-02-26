package com.taeyoung.comet.config.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.taeyoung.comet")
public class JpaConfig {

    @PersistenceContext
    private EntityManager entityManager;
    
//    Repository에서 RequiredConstruct 사용시
//    @Bean
//    public JPAQueryFactory queryFactory() {
//        return new JPAQueryFactory(entityManager);
//    }

}