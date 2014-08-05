Play Framework Sample Authentication
=================================


This is Sample project with form authentication by Play 2.3.

test user(name: `admin`, password: `password123`)

i used `Security.Authenticator` and [jBCrypt](http://www.mindrot.org/projects/jBCrypt/)

---

Play Framework 2.3 Javaでログイン認証をするサンプルです。

ユーザー名とパスワードのテストユーザーを作ってログインします。

ログインユーザー名は、`admin`、パスワードは`password123`です。

Playで用意されている`Security.Authenticator`クラスと、パスワードの暗号化に、[jBCrypt](http://www.mindrot.org/projects/jBCrypt/)を使っています。

ブログに詳細は書いてあります。

[Play Framework 2.3 For Java ことはじめ #10 ログイン認証編](http://mpon.hatenablog.com/entry/2014/08/06/023123)