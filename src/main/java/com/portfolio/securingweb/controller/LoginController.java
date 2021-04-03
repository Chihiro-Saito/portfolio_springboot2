package com.portfolio.securingweb.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.securingweb.domain.impl.UserDetailsImpl;

/**
 * ログイン処理のControllerクラス.
 */
@Controller
@RequestMapping("/usermaster")
public class LoginController {

    /**
     * ログイン画面のTemplateHTMLのパス.
     */
    private final String LOGIN_TEMPLATE_PATH = "usermaster/securingweb/login";

    /**
     * Redirect用一覧画面パス.
     */
    private final String REDIRECT_INDE_URL = "redirect:/usermaster/index";

    /**
     * ログイン画面表示のController.<br>
     * Getメソッドのみ許可.
     * @return ログイン画面のHTMLのパス
     */
    @GetMapping("login")
    public String login(){
        return LOGIN_TEMPLATE_PATH;
    }

    /**
     * ログインに成功した時のController.<br>
     * @param userDetails ユーザーの詳細情報
     * @param model Modelクラス
     * @return 遷移先
     */
    @PostMapping("success")
    public String loginSuccess(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {

        // TOPページに遷移する
        return REDIRECT_INDE_URL;
    }

}
