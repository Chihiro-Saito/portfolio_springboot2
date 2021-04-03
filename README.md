# portfolio_springboot2
Spring Boot2でユーザー情報を管理するWebシステムのサンプルコードです。<br>
ログイン認証（MySQLへのユーザー照合）、ユーザーの登録/更新/削除/参照といった基本的な操作が含まれています。

## Description
Spring Boot2で作ったWebシステムのサンプルコードです。<br>
Javaを学び初めた人向けに、Spring MVC・Spring Data JPA・Spring Securityの使い方を伝えることを目的としています。<br>
そのため、例外処理のハンドリングなど本来実装すべき処理を一部実装していませんので、ご容赦ください。<br>

## Demo
[![Image from Gyazo](https://i.gyazo.com/780e0f5ff7d02569f17a6dedb177d505.gif)](https://gyazo.com/780e0f5ff7d02569f17a6dedb177d505)

## Dependency
- Java SE Development Kit 11
- Eclipse Java EE IDE for Web Developers 2019-12 (4.14.0)
- MySQL 5.7
- Apache Maven 4
- MySQL JDBC Driver 5.1.45
- Spring Boot 2.4.3「Spring MVC（Thymeleaf）、Spring Data JPA、Spring Security」
- Bootstrap 5.0.0-beta2
- jQuery 3.6.0

## Setup
1. Eclipseで「Springスターター・プロジェクト」を以下のように設定し、作成します。<br>

| 画面 | 項目 | 設定値 |
| ------------- | ------------- | ------------- |
| 新規Spring スターター・プロジェクト | 型| Maven |
| 新規Spring スターター・プロジェクト | Javaバージョン | 11 |
| New Spring Starter Project Dependencies | Spring Boot Version | 2.4.3 |
| New Spring Starter Project Dependencies | 選択済み | Spring Boot Devtools |
| New Spring Starter Project Dependencies | 選択済み | Spring Data JPA |
| New Spring Starter Project Dependencies | 選択済み | Thymeleaf |
| New Spring Starter Project Dependencies | 選択済み | Spring Web |
| New Spring Starter Project Dependencies | 選択済み | Spring Reactive Web |
| New Spring Starter Project Dependencies | 選択済み | Spring Web Service |
| New Spring Starter Project Dependencies | 選択済み | Jersey |
| New Spring Starter Project Dependencies | 選択済み | Vaadin |

2. repositoryをcloneします。<br>
``$ git clone https://github.com/Chihiro-Saito/portfolio_springboot2.git``
3. プロジェクトをクリーンします。
4. application.propertiesをご利用のデータベース情報に変更します。<br>
``/portfolio_springboot2/src/main/resources/application.properties``<br>

| 項目 | 設定値 |
| ------------- | ------------- |
| spring.datasource.url | データベースの接続URL |
| spring.datasource.username | データベースの接続ユーザー |
| spring.datasource.password | 接続ユーザーのパスワード |
5. Eclipseの右下のビルド表示が消えたら、プロジェクトが実行できるか、確認します。
5-1. プロジェクト・エクスプローラーから以下のファイルを探します。<br>
``/portfolio_springboot2/src/main/java/com/portfolio/PortfolioApplication.java``<br>
5-2. PortfolioApplication.javaを右クリックし、「実行 > Spring Bootアプリケーション」を実行します。
1. ブラウザから以下のURLにアクセスします。<br>
``http://localhost:8080/usermaster/index``
2. 「新規作成」ボタンをクリックします。
3. ユーザー情報に以下の内容を入力し、「作成」ボタンをクリックします。<br>

| 項目 | 設定値 |
| ------------- | ------------- |
| ID | ユーザーID |
| 名前 | ユーザーの名前 |
| パスワード | ユーザーのパスワード |
| ロール | EDIT |
| 有効フラグ | true |

## Usage
1. 以下のURLにアクセスし、ログイン画面が表示されます。<br>
``http://localhost:8080/usermaster/login``
2. ユーザーID、パスワードを入力し、ログインします。

## License
This software is released under the MIT License, see LICENSE.

## Authors
Chihiro.Saito

## Reference
[Spring ドキュメント](https://spring.pleiades.io/)<br>
[Bootstrap5設置ガイド](https://bootstrap-guide.com/outline)<br>
[Login Formレイアウト](https://bootsnipp.com/snippets/z8aQr)
