package com.taeyoung.comet.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.taeyoung.comet.entity.SocialType;
import com.taeyoung.comet.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.taeyoung.comet.entity.QUser.user;

@Repository
//@RequiredArgsConstructor -> JpaConfig 사용시 추가
public class UserJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public UserJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public User save(User user){
        em.persist(user);
        return user;
    }

    public void saveAndFlush(User user){
        em.persist(user);
        em.flush();
    }

    public Optional<User> findById(Long id){
        User findUser = em.find(User.class, id);
        return Optional.ofNullable(findUser);
    }

    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

//    public Optional<User> findByNickname(String nickname){
//        return Optional.ofNullable(
//                em.createQuery("select u from User u where u.nickname = :nickname", User.class)
//                .setParameter("nickname", nickname)
//                .getSingleResult());
//    }

//    public Optional<User> findByRefreshToken(String refreshToken){
//        return Optional.ofNullable(
//                em.createQuery("select u from User u where u.refreshToken = :refreshToken", User.class)
//                        .setParameter("refreshToken", refreshToken)
//                        .getSingleResult());
//    }

//    public Optional<User>  findBySocialTypeAndSocialId(SocialType socialType, String socialId){
//        return Optional.ofNullable(
//                em.createQuery("select u from User u where u.socialType = :socialType " +
//                        "and u.socialId = :socialIds", User.class)
//                        .setParameter("socialType", socialType)
//                        .setParameter("socialType", socialType)
//                        .getSingleResult());
//        )
//    }

//    queryDSL
    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(
                query.select(user)
                        .from(user)
                        .where(user.email.eq(email))
                        .fetchOne());
    }

    public Optional<User> findByNickname(String nickname){
        return Optional.ofNullable(
                query.select(user)
                        .from(user)
                        .where(user.nickname.eq(nickname))
                        .fetchOne());
    }

    public Optional<User> findByRefreshToken(String refreshToken){
        return Optional.ofNullable(
                query.select(user)
                        .from(user)
                        .where(user.refreshToken.eq(refreshToken))
                        .fetchOne());
    }

    public Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId){
        return Optional.ofNullable(
                query.select(user)
                        .from(user)
                        .where(
                                user.socialType.eq(socialType),
                                user.socialId.eq(socialId)
                        )
                        .fetchOne());
    }
}
