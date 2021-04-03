package com.portfolio.securingweb.service;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.securingweb.domain.User;
import com.portfolio.securingweb.repository.UserRepository;

/**
 * UserEntityクラスを操作するServiceクラス.
 */
@Service
@Transactional
public class UserService {

    /**
     * User(Entity)クラスのリポジトリクラス.
     */
    @Autowired
    private UserRepository repository;

    /**
     * PasswordEncoderクラス.
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * User(Entity)クラスのデータを全件取得する.
     * @return 取得結果
     */
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * IDに紐付くUser(Entity)クラスのデータを1件取得する.
     * @param id
     * @return 取得結果
     */
    public User findOne(String id) {
        return repository.getOne(id);
    }

    /**
     * User(Entity)クラスのデータを保存する.
     * @param user
     * @return 保存したuser
     */
    public User save(User user) {
        String password  = user.getPassword();

        // パスワードが空か判定
        if (Strings.isBlank(password)) {
            // 空の場合
            // DBからパスワードを取得し、User(Entity)クラスのパスワードに設定
            User dbData = this.findOne(user.getId());
            user.setPassword(dbData.getPassword());

        } else {
            // 空以外の場合
            // パスワードを暗号化し、User(Entity)クラスのパスワードに設定
            user.setPassword(passwordEncoder.encode(password));
        }

        return repository.save(user);
    }

    /**
     * IDに紐付くUser(Entity)クラスのデータを削除する.
     * @param id
     */
    public void delete(String id) {
        repository.deleteById(id);
    }

    /**
     * IDに紐付くUser(Entity)クラスの件数を取得する.
     * @param id
     */
    public long countById(String id) {
        return repository.countById(id);
    }
}
