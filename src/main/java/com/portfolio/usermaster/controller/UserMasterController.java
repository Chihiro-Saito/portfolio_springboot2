package com.portfolio.usermaster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.securingweb.domain.User;
import com.portfolio.securingweb.service.UserService;
import com.portfolio.usermaster.validation.sub.UserCreateForm;
import com.portfolio.usermaster.validation.sub.UserUpdateForm;

/**
 * ユーザーマスタ画面のコントローラークラス.<br/>
 * クラスで@RequestMappingを利用すると、<br/>
 * リクエストURLが「クラスの@RequestMappingで指定したパス + メソッドで指定したパス」になります。
 */
@Controller
@RequestMapping("/usermaster")
public class UserMasterController {

    /**
     * UserEntityクラスを操作するServiceクラス.
     */
    @Autowired
    private UserService userService;

    /**
     * Redirect用一覧画面パス.
     */
    private final String REDIRECT_INDE_URL = "redirect:/usermaster/index";


    /**
     * 新規登録画面のTemplateHTMLのパス.
     */
    private final String NEW_TEMPLATE_PATH = "usermaster/usermaster/new";

    /**
     * 編集画面のTemplateHTMLのパス.
     */
    private final String EDIT_TEMPLATE_PATH = "usermaster/usermaster/edit";

    /**
     * 詳細画面のTemplateHTMLのパス.
     */
    private final String SHOW_TEMPLATE_PATH = "usermaster/usermaster/show";

    /**
     * ユーザーマスタ一覧画面表示.
     * @param model
     * @return HOME画面のテンプレートパス
     */
    @RequestMapping("index")
    public String index(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "usermaster/usermaster/index";
    }

    /**
     * ユーザー新規登録画面表示.
     * @param userCreateForm
     * @param model
     * @return ユーザー新規登録画面のテンプレートパス
     */
    @GetMapping("new")
    public String newUser(UserCreateForm userCreateForm, Model model) {
        model.addAttribute("userCreateForm", userCreateForm);
        return NEW_TEMPLATE_PATH;
    }

    /**
     * ユーザー編集画面表示.
     * @param id ユーザーID
     * @param model
     * @return ユーザー編集画面のテンプレートパス
     */
    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("userUpdateForm", new UserUpdateForm(user));
        return EDIT_TEMPLATE_PATH;
    }

    /**
     * ユーザー詳細画面表示.
     * @param id ユーザーID
     * @param model
     * @return ユーザー詳細画面のテンプレートパス
     */
    @GetMapping("show/{id}")
    public String show(@PathVariable String id, Model model) {
        // ユーザー情報を取得
        User user = userService.findOne(id);
        model.addAttribute("user", user);

        return SHOW_TEMPLATE_PATH;
    }

    /**
     * ユーザーの新規登録処理.
     * @param userCreateForm 新規登録画面の入力情報
     * @param model
     * @return 遷移先パス(エラーの場合、新規登録画面のテンプレートパス。成功の場合、Topページ)
     */
    @PostMapping("create")
    public String create(@Valid UserCreateForm userCreateForm,
            final BindingResult bindingResult, Model model) {

        // 入力チェック
        if (bindingResult.hasErrors()) {
            // 入力チェックエラー時の処理
            return NEW_TEMPLATE_PATH;
        }

        User user = userCreateForm.toEntity();

        // ユーザー情報を保存
        userService.save(user);

        return REDIRECT_INDE_URL;
    }

    /**
     * ユーザーの更新処理.
     * @param id ユーザーID
     * @param userUpdateForm 編集画面の入力情報
     * @param bindingResult 入力チェック結果
     * @param model
     * @return 遷移先パス(エラーの場合、編集画面のテンプレートパス。成功の場合、Topページ)
     */
    @PostMapping("update/{id}")
    public String update(@PathVariable String id, @Valid UserUpdateForm userUpdateForm,
            final BindingResult bindingResult, Model model) {

        // 入力チェック
        if (bindingResult.hasErrors()) {
            // 入力チェックエラー時の処理
            return EDIT_TEMPLATE_PATH;
        }

        User user = userUpdateForm.toEntity();

        // ユーザー情報を保存
        userService.save(user);

        return REDIRECT_INDE_URL;
    }

    /**
     * ユーザーの更新処理.
     * @param id ユーザーID
     * @param model
     * @return TopページのURL
     */
    @PostMapping("delete/{id}")
    public String destroy(@PathVariable String id) {
        userService.delete(id);
        return REDIRECT_INDE_URL;
    }

}
