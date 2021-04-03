package com.portfolio.usermaster.check.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.securingweb.service.UserService;
import com.portfolio.usermaster.check.CustomCheck;

/**
 * CustomCheckの実装クラス.
 *
 */
public class CustomCheckValidatorr implements ConstraintValidator<CustomCheck, Object> {

    /** アノテーションで指定したmessageの項目名 */
    private String message;

    /** アノテーションで指定したユーザーの項目名 */
    private String uniqueUserId;

    /**
     * UserEntityクラスを操作するServiceクラス.
     */
    @Autowired
    private UserService userService;

    /**
     * 初期化処理.
     * @param annotation
     */
    @Override
    public void initialize(CustomCheck annotation) {
        //アノテーションで指定したユーザーID・メッセージの項目名を取得
        this.setUniqueUserId(annotation.uniqueUserId());
        this.setMessage(annotation.message());
    }

    /**
     * バリデーションの検証.
     * @param value
     * @param context
     * @return 検証結果
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        String userId = (String) value;
        if (this.checkNoUniqueUserId(userId)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
            .addConstraintViolation();

            return false;

        }

        return true;
    }
    public String getUniqueUserId() {
        return uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * ユーザーIDが一意か、チェックするメソッド.
     * @param userId ユーザーID
     * @return 検証結果(true：一意、false：重複)
     */
    private boolean checkNoUniqueUserId(String userId){
        // ユーザーIDが空か判定
        if(StringUtils.isBlank(userId)){
            // 空の場合、後続の処理をせず終了
            return false;
        }

        // IDに紐付くユーザー情報の件数を取得
        long count = userService.countById(userId);

        // 件数を判定
        if (count == 0) {
            // 0件の場合、一意とする
            return false;
        }

        return true;
    }

}
