package com.portfolio.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.portfolio.securingweb.service.impl.UserDetailsServiceImpl;

/**
 * 認証・認可を設定するクラス.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     */
    @Autowired
    UserDetailsServiceImpl service;


    /**
     * パスワードの暗号化クラスを返却するメソッド.
     * @return BCryptPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 認証を除外する対象を設定するメソッド.
     * @param WebSecurity
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // spring securityで無視するリクエストパスを設定
        // 静的ファイルを除外する
        web.ignoring().antMatchers("/css/**", "/resources/**");

    }

    /**
     * 認証方法を設定するメソッド.
     * @param AuthenticationManagerBuilder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 拡張してDB認証を実行する
        auth.userDetailsService(service);
    }

    /**
     * 認証対象やログイン・ログアウト処理を設定するメソッド.
     * @param HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ログイン処理の認証ルールを設定
        http.authorizeRequests()
        // TODO 開発中のみ有効にする
        .antMatchers("/**").permitAll()
        // TODO 開発が終わったら、認証を有効にする
        //		.antMatchers("/usermaster", "/usermaster/login").permitAll() // 認証なしでアクセス可能なパス
        //		.antMatchers("/usermaster/edit/**").hasAuthority("EDIT")     // EDITロールを持つユーザーのみアクセス許可
        //		.antMatchers("/usermaster/delete/**").hasAuthority("EDIT")   // EDITロールを持つユーザーのみアクセス許可
        .anyRequest().authenticated() // それ以外は認証が必要
        .and()
        .sessionManagement().sessionFixation().none()
        .and()
        .formLogin()
        .loginPage("/usermaster/login")
        .loginProcessingUrl("/usermaster/login") // ログインフォームのアクションに指定したURL[action="@{/login}"]を設定
        .usernameParameter("userId") // ログインフォームのユーザー欄のname属性を設定
        .passwordParameter("password") // ログインフォームのパスワード欄のname属性を設定
        .successForwardUrl("/usermaster/success") // ログイン成功時に遷移するURL
        .failureUrl("/usermaster/login?error") // ログイン失敗時に遷移するURL
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/usermaster/logout")
        .permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/usermaster/logout"));
    }

}
