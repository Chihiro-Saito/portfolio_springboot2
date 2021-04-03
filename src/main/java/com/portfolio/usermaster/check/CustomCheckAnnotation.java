package com.portfolio.usermaster.check;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * CustomCheckAnnotationのインターフェース.<br/>
 * カスタマイズチェックのアノテーションチェック処理を<br/>
 * 1クラスで複数回実施できるように設定.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomCheckAnnotation  {
    CustomCheck[] value();
}
