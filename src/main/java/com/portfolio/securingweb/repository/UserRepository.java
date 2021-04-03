package com.portfolio.securingweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portfolio.securingweb.domain.User;

/**
 * User(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    /** IDに紐付くUser(Entity)クラスの件数を取得. */
    @Query("select count(e) from User e WHERE e.id = :id")
    long countById(String id);
}
