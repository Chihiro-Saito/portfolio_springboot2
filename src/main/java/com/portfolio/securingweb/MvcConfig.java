package com.portfolio.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * URLとコントローラーを追加(マッピング)するクラス.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * URLとコントローラーを追加(マッピング)するメソッド.
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("usermaster/usermaster/index");
        registry.addViewController("/usermaster").setViewName("usermaster/usermaster/index");
    }

}
