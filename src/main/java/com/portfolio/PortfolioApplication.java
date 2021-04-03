package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Bootに同梱されたTomcatを起動するクラス.
 */
@SpringBootApplication
@EnableJpaRepositories
public class PortfolioApplication {

    /**
     * ポートフォリオアプリケーションの実行メソッド.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

}
