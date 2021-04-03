package com.portfolio.securingweb.domain.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.securingweb.domain.User;

/**
 * ユーザー詳細情報の拡張クラス.
 *
 */
public class UserDetailsImpl  implements UserDetails {

    private static final long serialVersionUID = 1L;

    /** ユーザーEntityクラス. */
    private User user;

    /** 権限情報. */
    private Collection<GrantedAuthority> authorities;


    /**
     * コンストラクタ.
     * @param user ユーザーEntityクラス
     * @param authorities 権限情報
     */
    public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public String getId() {
        return user.getId();
    }

    public String getName() {
        return user.getName();
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getUsername() {
        return user.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return user.isEnabled();
    }
    @Override
    public boolean isAccountNonLocked() {
        return user.isEnabled();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return user.isEnabled();
    }

}
