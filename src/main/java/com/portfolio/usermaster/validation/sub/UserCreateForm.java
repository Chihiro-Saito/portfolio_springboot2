package com.portfolio.usermaster.validation.sub;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.portfolio.securingweb.domain.User;
import com.portfolio.usermaster.check.CustomCheck;
import com.portfolio.usermaster.validation.UserBaseForm;

/**
 * ユーザー新規登録画面のFormクラス.
 */
public class UserCreateForm extends UserBaseForm {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max=30)
    @CustomCheck(uniqueUserId = "id", message = "既に登録されています")
    private String id;


    @NotBlank
    @Size(max=255)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Formクラスの設定内容を文字列で出力するメソッド.
     */
    @Override
    public String toString() {
        return "User(id: " + this.getId() + ", Name: " + super.getName() +
                ", Password: " + this.getPassword() + ", Role: " + super.getRole() +
                ", enabled: " + super.isEnabled() +")";
    }

    /**
     * Formの設定内容をUser Entityクラスに変換するメソッド.
     * @return User Entityクラス
     */
    public User toEntity(){

        User user = new User();
        user.setId(this.getId());
        user.setName(super.getName());
        user.setPassword(this.getPassword());
        user.setRole(super.getRole());
        user.setEnabled(super.isEnabled());

        return user;
    }
}
