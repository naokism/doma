/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.message;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.seasar.doma.internal.message.MessageResourceBundle;

/**
 * デフォルトロケール用のメッセージの列挙です。
 * 
 * @author taedium
 * 
 */
public enum Message implements MessageResource {

    // doma
    DOMA0001("パラメータ[{0}]がnullです。"),
    DOMA0002("パラメータ[{0}]が不正です。理由は次のとおりです。{1}"),
    DOMA0003("Domaのjarファイルのバージョンが実行時と注釈処理時で異なっています（実行時={0}, 注釈処理時={1}）。Eclipseを使用している場合、ビルドパス（Build Path）とファクトリパス（Factory Path）を確認し、プロジェクトのクリーンを実行してください。javacを利用している場合、classpathとprocessorpathのオプションを確認してください。Webアプリケーションの場合、WEB-INF/libに古いjarファイルが存在しないことを確認してください。"),

    // wrapper
    DOMA1006("ドメインの値をラップするのに失敗しました。原因は次のものです。{0}"),
    DOMA1007("型[{0}]の値[{1}]に対応するラッパークラスが見つかりません。"),

    // jdbc
    DOMA2001("SQLの実行結果が1件ではありませんでした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2002("カラム[{0}]が結果セットに含まれますが、このカラムにマッピングされたプロパティがエンティティクラス[{2}]に見つかりません。エンティティクラスに[{1}]という名前のプロパティを定義するか、任意の名前のプロパティに@Columnを注釈し@Columnのname要素に[{0}]を指定してください。\nSQLファイルパス=[{3}]。\nログ用SQL=[{4}]"),
    DOMA2003("楽観的排他制御により更新処理が失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2004("一意制約違反により更新処理が失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。\n詳しい原因は次のものです。{2}"),
    DOMA2005("SQLの実行結果が0件でした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2006("SQLの実行結果が1列ではありませんでした。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。"),
    DOMA2008("JDBCに関する操作に失敗しました。原因は次のものです。{1}"),
    DOMA2009("SQLの実行に失敗しました。\nSQLファイルパス=[{0}]。\nログ用SQL=[{1}]。\n原因は次のものです。{2}。\n根本原因は次のものです。{3}"),
    DOMA2010("SQLファイル[{0}]のデータを取得できませんでした。原因は次のものです。{1}"),
    DOMA2011("SQLファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA2012("スクリプトファイル[{0}]がクラスパスから見つかりませんでした。"),
    DOMA2015("java.sql.Connectionの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2016("java.sql.PreparedStatementの取得に失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n原因は次のものです。{2}"),
    DOMA2017("エンティティ[{0}]のIDプロパティの生成に失敗しました。"),
    DOMA2018("エンティティ[{0}]のIDプロパティの生成に失敗しました。原因は次のものです。{1}"),
    DOMA2019("Wrapperクラス[{0}]がJDBCの型にマッピングされていません。"),
    DOMA2020("エンティティ[{0}]のIDプロパティ[{1}]に値が設定されていません。IDのプロパティに@GeneratedValueが指定されていない場合、INSERTの実行にはIDプロパティの設定が必須です。"),
    DOMA2021("エンティティ[{0}]のIDプロパティ[{1}]に自動生成のstrategy[{2}]が指定されていますが、DBMS[{3}]ではサポートされていません。"),
    DOMA2022("IDプロパティのないエンティティ[{0}]の更新や削除はできません。"),
    DOMA2023("悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2024("テーブル名もしくはカラム名を指定した悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2025("java.sql.CallableStatementの取得に失敗しました。\n実際のSQL=[{0}]。\n原因は次のものです。{1}"),
    DOMA2028("楽観的排他制御によりバッチ更新処理が失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。"),
    DOMA2029("一意制約違反によりバッチ更新処理が失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n詳しい原因は次のものです。{2}"),
    DOMA2030("バッチ更新処理の実行に失敗しました。\nSQLファイルパス=[{0}]。\n実際のSQL=[{1}]。\n原因は次のものです。{2}。\n根本原因は次のものです。{3}"),
    DOMA2032("java.sql.Statementの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2033("インスタンス変数[{0}]が未設定です。"),
    DOMA2034("クラス[{0}]のサポートされてないメソッド[{1}]が呼び出されました。"),
    DOMA2035("org.seasar.doma.jdbc.Configの実装クラス[{0}]のメソッド[{1}]からnullが返されました。"),
    DOMA2040("列挙型[{0}]に定数名[{1}]は存在しません。"),
    DOMA2041("自動コミットモードの無効化に失敗しました。原因は次のものです。{0}"),
    DOMA2042("自動コミットモードの有効化に失敗しました。原因は次のものです。{0}"),
    DOMA2043("コミットに失敗しました。原因は次のものです。{0}"),
    DOMA2044("ロールバックに失敗しました。原因は次のものです。{0}"),
    DOMA2045("ローカルトランザクションを開始しようとしましたが失敗しました。ローカルトランザクション[{0}]がすでに開始されています。"),
    DOMA2046("ローカルトランザクションをコミットしようとしましたが失敗しました。ローカルトランザクションが開始されていません。"),
    DOMA2048("コネクションを取得しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2049("コネクションの遅延取得に失敗しました。原因は次のものです。{0}"),
    DOMA2051("セーブポイント[{0}]の作成に失敗しました。原因は次のものです。{1}"),
    DOMA2052("セーブポイント[{0}]のロールバックに失敗しました。原因は次のものです。{1}"),
    DOMA2053("セーブポイント[{0}]を作成しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2054("セーブポイント[{0}]が見つかりませんでした。セーブポイントをロールバックする前に[{0}]という名前のセーブポイントを作成していることを確認してください。"),
    DOMA2055("トランザクション分離レベル[{0}]の設定に失敗しました。原因は次のものです。{1}"),
    DOMA2056("トランザクション分離レベルの取得に失敗しました。原因は次のものです。{0}"),
    DOMA2057("セーブポイント[{0}]の作成有無を確認しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2059("セーブポイント[{0}]がすでに存在します。同じ名前のセーブポイントを複数作成することはできません。"),
    DOMA2060("セーブポイント[{0}]の削除に失敗しました。原因は次のものです。{1}"),
    DOMA2061("セーブポイント[{0}]を削除しようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2062("セーブポイント[{0}]をロールバックしようとしましたが失敗しました。トランザクションが開始されていません。"),
    DOMA2063("ローカルトランザクション[{0}]を開始しました。"),
    DOMA2064("ローカルトランザクション[{0}]を終了しました。"),
    DOMA2065("ローカルトランザクション[{0}]のセーブポイント[{1}]を作成しました。"),
    DOMA2066("ローカルトランザクション[{0}]のセーブポイント[{1}]を開放しました。"),
    DOMA2067("ローカルトランザクション[{0}]をコミットしました。"),
    DOMA2068("ローカルトランザクション[{0}]をロールバックしました。"),
    DOMA2069("ローカルトランザクション[{0}]のセーブポイント[{1}]へロールバックしました。"),
    DOMA2070("ローカルトランザクション[{0}]のロールバックに失敗しました。"),
    DOMA2071("自動コミットモードの有効化に失敗しました。"),
    DOMA2072("トランザクション分離レベル[{0}]の設定に失敗しました。"),
    DOMA2073("java.sql.Connectionのクローズに失敗しました。"),
    DOMA2074("java.sql.Statementのクローズに失敗しました。"),
    DOMA2075("java.sql.ResultSetのクローズに失敗しました。"),
    DOMA2076("SQLログ : SQLファイル=[{0}],\n{1}"),
    DOMA2077("スクリプトの実行に失敗しました。\nSQLファイル=[{1}]。\n行番号=[{2}]。\n原因は次のものです。{3}。\nSQL=[{0}]。"),
    DOMA2078("SQLファイル[{0}]の読み込みに失敗しました。\n原因は次のものです。{1}"),
    DOMA2079("WAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2080("NOWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2081("テーブル名もしくはカラム名を指定したWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2082("テーブル名もしくはカラム名を指定したNOWAITオプション付きの悲観的排他制御は、DBMS[{0}]ではサポートされていません。"),
    DOMA2101("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。文字列リテラルの終了を示すクォテーション['']が見つかりません。SQL[{0}]"),
    DOMA2102("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。ブロックコメントの終了を示す文字列[*/]が見つかりません。SQL[{0}]"),
    DOMA2103("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。--elseifの終了を示す文字列[--]が見つかりません。SQL[{0}]"),
    DOMA2104("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。/*%end*/に対応する/*%if ...*/または/*%for ...*/が見つかりません。SQL[{0}]"),
    DOMA2105("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。--elseに対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2106("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。--elseifに対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2107("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。複数の--elseもしくは/*%else*/が存在します。SQL[{0}]"),
    DOMA2108("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。--elseもしくは/*%else*/の後ろに--elseifが存在します。SQL[{0}]"),
    DOMA2109("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。閉じ括弧に対応する開き括弧が見つかりません。SQL[{0}]"),
    DOMA2110("SQLの解析に失敗しました。（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]の直後にテスト用のリテラルもしくは括弧が見つかりません。SQL[{0}]"),
    DOMA2111("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。原因は次のものです。{3}。SQL[{0}]"),
    DOMA2112("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。括弧の前に位置するバインド変数コメント[{3}]に対応するオブジェクトの型[{4}]がjava.lang.Iterableのサブタイプではありません。SQL[{0}]"),
    DOMA2115("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。括弧の前に位置するバインド変数コメント[{3}]に対応するjava.lang.Iterableの[{4}]番目の要素がnullです。SQL[{0}]"),
    DOMA2116("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にシングルクォテーションが含まれています。SQL[{0}]"),
    DOMA2117("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にセミコロンが含まれています。SQL[{0}]"),
    DOMA2118("SQLの組み立てに失敗しました。（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]を正しく扱えませんでした。原因は次のものです。{4}。SQL[{0}]"),
    DOMA2119("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。ブロックコメントを/*%で開始する場合、続く文字列は、if、else, elseif, for、endのいずれかでなければいけません。SQL[{0}]"),
    DOMA2120("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]が定義されていますが、バインド変数が空文字です。SQL[{0}]"),
    DOMA2121("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]が定義されていますが、埋め込み変数が空文字です。SQL[{0}]"),
    DOMA2122("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]に行コメントが含まれています。SQL[{0}]"),
    DOMA2123("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。埋め込み変数コメント[{3}]にブロックコメントが含まれています。SQL[{0}]"),
    DOMA2124("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中にトークン[:]が見つかりません。SQL[{0}]"),
    DOMA2125("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中のトークン[:]の前に識別子が見つかりません。SQL[{0}]"),
    DOMA2126("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--/*%for ...*/の中のトークン[:]の後に式が見つかりません。SQL[{0}]"),
    DOMA2129("SQLの組み立てに失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%for ...*/の中のトークン[:]の後に続く式[{3}]に対応するオブジェクトの型[{4}]がjava.lang.Iterableのサブタイプではありません。SQL[{0}]"),
    DOMA2133("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/%if ...*/が/*%end*/で閉じられていません。/%if ...*/と/*%end*/の組は、同じ節（たとえばSELECT、FROM、WHERE節など）の中に存在しなければいけません。SQL[{0}]"),
    DOMA2134("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/%for ...*/が/*%end*/で閉じられていません/%for ...*/と/*%end*/の組は、同じ節（たとえばSELECT、FROM、WHERE節など）の中に存在しなければいけません。SQL[{0}]"),
    DOMA2135("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。括弧が閉じられていません。もしくは/%if ...*/～/*%end*/や/%for ...*/～/*%end*/を使用していて、開き括弧と閉じ括弧が同じブロック内にありません。SQL[{0}]"),
    DOMA2136("Daoメソッドのパラメータ[{0}]に対応する結果セットがストアドプロシージャもしくはストアドファンクション[{1}]から返されませんでした。"),
    DOMA2137("[{0}]番目のパラメータ[{1}]に対応する結果セットがストアドプロシージャもしくはストアドファンクション[{2}]から返されませんでした。"),
    DOMA2138("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%elseif ...*/に対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2139("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。--elseもしくは/*%else*/の後ろに/*%elseif ...*/が存在します。SQL[{0}]"),
    DOMA2140("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。/*%else*/に対応する/*%if ...*/が見つかりません。SQL[{0}]"),
    DOMA2141("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。複数の--elseもしくは/*%else*/が存在します。SQL[{0}]"),
    DOMA2142("SQLの解析に失敗しました（[{1}]行目[{2}]番目の文字付近）。バインド変数コメント[{3}]の直後の値[{4}]はテスト用のリテラルとして不正です。バインド変数コメントの直後は、文字列、数値、日時を表すリテラル、もしくは開き括弧でなければいけません。SQL[{0}]"),
    DOMA2201("ページング用SQLに変換するには元のSQLにorder by句が指定されている必要があります。"),
    DOMA2202("ドメインクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2203("エンティティクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),
    DOMA2204("パラメータ[{0}]が不正です。パラメータはエンティティクラス、ドメインクラス、基本型のいずれかでなければいけません。詳細な原因は次のものです。{1}"),
    DOMA2205("クラス[{0}]は、@Domainもしくは@EnumDomainが注釈されていなければいけません。"),
    DOMA2206("クラス[{0}]は、@Entityが注釈されていなければいけません。"),
    DOMA2207("エンティティプロパティ[{1}]がエンティティクラス[{0}]に定義されていません。"),
    DOMA2208("エンティティクラス[{0}]のエンティティプロパティ[{1}]へのアクセスに失敗しました。原因は次のものです。{2}"),
    DOMA2209("ラッパークラス[{0}]のコンストラクタが見つかりません。原因は次のものです。{1}"),
    DOMA2210("ラッパークラス[{0}]をインスタンス化できません。原因は次のものです。{1}"),
    DOMA2211("エンティティプロパティ[{1}]がエンティティクラス[{0}]で見つかりません。原因は次のものです。{2}"),
    DOMA2212("エンティティクラス[{0}]の@OriginalStatesが注釈されたフィールド[{1}]へのアクセスに失敗しました。原因は次のものです。{2}"),
    DOMA2213("@OriginalStatesが注釈されたフィールド[{1}]がエンティティクラス[{0}]で見つかりません。原因は次のものです。{2}"),
    DOMA2214("ドメインクラス[{0}]に対応するメタクラス[{1}]が見つかりませんでした。原因は次のものです。{2}"),

    // expression
    DOMA3001("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]の実行に失敗しました。原因は次のものです。{4}"),
    DOMA3002("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のメソッド[{3}]が見つかりませんでした。メソッド名、パラメータの数、パラメータの型が正しいか確認してください。"),
    DOMA3003("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。変数[{2}]に対応するオブジェクトを解決できませんでした。変数名が正しいか確認してください。"),
    DOMA3004("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字列リテラルの終了を示すダブルクォテーション[\"]が見つかりません。"),
    DOMA3005("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]が見つかりませんでした。クラス名が正しいか確認してください。"),
    DOMA3006("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]が見つかりませんでした。コンストラクタのパラメータの数や型が正しいか確認してください。"),
    DOMA3007("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。コンストラクタ[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3008("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。被演算子のクラスがjava.lang.Comparableを実装していないか、2つの被演算子の型が比較不可能なのかもしれません。原因は次のものです。{3}"),
    DOMA3009("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。比較演算子[{2}]の実行に失敗しました。どちらかの値がnullの場合には、比較できません。"),
    DOMA3010("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。演算子[{2}]に対する被演算子が見つかりませんでした。"),
    DOMA3011("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。サポートされていないトークン[{2}]が見つかりました。"),
    DOMA3012("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。不正な数値リテラル[{2}]が見つかりました。"),
    DOMA3013("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。被演算子[{3}]のクラス[{4}]が数値型ではありません。"),
    DOMA3014("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。算術演算子[{2}]の実行に失敗しました。原因は次のものです。{3}"),
    DOMA3015("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。演算子[{2}]の実行に失敗しました。被演算子の値がnullです。"),
    DOMA3016("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。文字リテラルの終了を示すクォテーション['']が見つかりません。文字リテラルの長さは1でなければいけません。"),
    DOMA3018("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のフィールド[{3}]が見つかりませんでした。フィールド名が正しいか確認してください。"),
    DOMA3019("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のフィールド[{3}]へのアクセスに失敗しました。原因は次のものです。{4}"),
    DOMA3020("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。演算子[{2}]の実行に失敗しました。文字の連結を行う場合、右被演算子[{3}]のクラス[{4}]はString、Character、charのいずれかでなければいけません。数値を加算する場合、両被演算子は数値型でなければいけません。"),
    DOMA3021("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[.]の直後にはフィールド名もしくはメソッド名が続かなければいけません。"),
    DOMA3022("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[.]の直後にはフィールド名もしくはメソッド名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3023("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはクラスの完全修飾名もしくは組み込み関数名が続かなければいけません。"),
    DOMA3024("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後には組み込み関数名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3025("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。組み込み関数名の直後にトークン[(]が必要です。"),
    DOMA3026("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。括弧が閉じられていません。"),
    DOMA3027("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。式[{2}]がnullと評価されためメソッド[{3}]を実行できませんでした。"),
    DOMA3028("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。関数[{2}]が見つかりませんでした。関数名、パラメータの数、パラメータの型が正しいか確認してください。"),
    DOMA3029("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはstaticなフィールド名もしくはメソッド名が続かなければいけません。"),
    DOMA3030("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。トークン[@]の直後にはstaticなフィールド名もしくはメソッド名が続かなければいけませんが、文字[{2}]がJavaの識別子の最初の文字として不正です。"),
    DOMA3031("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。クラス名の終了を示すトークン[@]の前に、クラス名として不正な文字[{2}]がみつかりました。"),
    DOMA3032("式[{0}]の解析に失敗しました（[{1}]番目の文字付近）。クラス名はトークン[@]で囲まなければいけません。"),
    DOMA3033("式[{0}]の評価に失敗しました（[{1}]番目の文字付近）。クラス[{2}]のstaticフィールド[{3}]が見つかりませんでした。フィールド名が正しいか確認してください。"),

    // apt
    DOMA4001("戻り値の型は更新件数を示すintでなければいけません。"),
    DOMA4002("パラメータの数は1つでなければいけません。"),
    DOMA4003("パラメータはエンティティクラスでなければいけません。"),
    DOMA4005("@Selectや@Updateなど問い合わせの種別を表すアノテーションが必要です。"),
    DOMA4007("戻り値のjava.util.Listに対する実型引数の型[{0}]はサポートされていません。サポートされている型は次のものです。基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>。"),
    DOMA4008("戻り値の型[{0}]はサポートされていません。戻り値の型は次のいずれかでなければいけません。基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>、基本型を要素とするjava.util.List、ドメインクラスを要素とするjava.util.List、エンティティクラスを要素とするjava.util.List、java.util.Map<String, Object>を要素とするjava.util.List。"),
    DOMA4011("クラス[{0}]のアノテーション処理に失敗しました。原因は次のものです。{1}"),
    DOMA4014("インタフェース以外には注釈できません。"),
    DOMA4015("クラス以外には注釈できません。"),
    DOMA4016("予期しない例外が発生しました。原因の詳細についてはログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4017("Daoインタフェースはトップレベルでなければいけません。"),
    DOMA4018("エンティティクラスはトップレベルでなければいけません。"),
    DOMA4019("ファイル[{0}]がクラスパスから見つかりませんでした。ファイルの絶対パスは\"{1}\"です。"),
    DOMA4020("SQLファイル[{0}]が空です。"),
    DOMA4021("パス[{0}]はディレクトリです。ファイルでなければいけません。絶対パスは\"{1}\"です。"),
    DOMA4024("@Versionが重複しています。@Versionが注釈されるフィールドはクラス階層の中で1つでなければいけません。"),
    DOMA4025("[{0}]で始まる名前はDomaにより予約されているため使用できません。"),
    DOMA4026("[{0}]で終わる名前は自動生成されるクラスの名前と重複する可能性があります。"),
    DOMA4030("@SequenceGeneratorを使用する場合、同じフィールドに@GeneratedValue(strategy = GenerationType.SEQUENCE)を指定しなければいけません。"),
    DOMA4031("@TableGeneratorを使用する場合、同じフィールドに@GeneratedValue(strategy = GenerationType.TABLE)を指定しなければいけません。"),
    DOMA4033("@GeneratedValueを使用する場合、同じフィールドに@Idを指定しなければいけません。"),
    DOMA4034("@GeneratedValueのstrategy要素にGenerationType.SEQUECNEを指定する場合、@SequenceGeneratorの指定も必要です。"),
    DOMA4035("@GeneratedValueのstrategy要素にGenerationType.TABLEを指定する場合、@TableGeneratorの指定も必要です。"),
    DOMA4036("@GeneratedValueを使用する場合、エンティティクラスの階層で@Idは１つのみでなければいけません。"),
    DOMA4037("複数の@GeneratedValueが見つかりました。@GeneratedValueは1つでなければいけません。"),
    DOMA4038("EntityListener[{0}]の実型引数の型[{1}]はエンティティクラス[{2}]のスーパータイプでなければいけません。"),
    DOMA4039("コンパイルが失敗している可能性があるためaptの処理を中止します。コンパイルが失敗している原因については実行環境（Eclipseやjavac）のエラーメッセージを確認してください。このメッセージが生成された箇所を知りたい場合は、ログ(EclipseならばError Logビュー、javacならばコンソールなど)を確認してください。"),
    DOMA4040("戻り値の型は更新件数を示すintの配列でなければいけません。"),
    DOMA4042("型はjava.lang.Iterableのサブタイプでなければいけません。"),
    DOMA4043("java.lang.Iterableのサブタイプに対する実型引数はエンティティクラスでなければいけません。"),
    DOMA4051("エンティティクラスには型パラメータを定義できません。"),
    DOMA4053("SelectOption型のパラメータは複数指定できません。"),
    DOMA4054("IterationCallback型のパラメータは複数指定できません。"),
    DOMA4055("戻り値の型[{0}]とIterationCallbackの1番目の実型引数の型[{1}]が一致していません。"),
    DOMA4056("@Selectのiterate要素にtrueを設定した場合、IterationCallback型のパラメータが必要です。"),
    DOMA4057("IterationCallback型のパラメータを利用するには、iterate要素にtrueを設定しなければいけません。"),
    DOMA4058("IterationCallbackの2番目の実型引数の型は、基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>のいずれかでなければいけません。"),
    DOMA4059("Daoインタフェースには型パラメータを定義できません。"),
    DOMA4062("@ResultSetが注釈されたパラメータの型は、java.util.Listでなければいけません。"),
    DOMA4063("@Functionの戻り値として型[{0}]はサポートされていません。戻り値の型は、次のいずれかでなければいけません。基本型、ドメインクラス、基本型を要素とするjava.util.List、ドメインクラスを要素とするjava.util.List、エンティティクラスを要素とするjava.util.List。"),
    DOMA4064("@Procedureが注釈されたメソッドの戻り値の型はvoidでなければいけません。"),
    DOMA4065("戻り値のjava.util.Listに対する実型引数の型[{0}]は、サポートされていません。サポートされている型は次のものです。基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>。"),
    DOMA4066("@Functionもしくは@Procedureが注釈されたメソッドのパラメータには、@In、@InOut、@Out、@ResultSetのいずれかの注釈が必須です。"),
    DOMA4067("SQL内の変数[{0}]に対応するパラメータがメソッドに存在しません（[{1}]番目の文字付近）。"),
    DOMA4068("SQLファイル[{0}]の読み込みに失敗しました。原因は次のものです。{1}"),
    DOMA4069("SQLファイル[{0}]の解析に失敗しました。原因は次のものです。{1}"),
    DOMA4071("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]（フィールドもしくはメソッドの戻り値の型が[{3}]）からpublicで戻り値を返すメソッド[{4}]が見つかりません。"),
    DOMA4072("式[{0}]（[{1}]番目の文字付近）に含まれる関数[{2}]が見つかりません。"),
    DOMA4073("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]（フィールドもしくはメソッドの戻り値の型が[{3}]）からpublicで戻り値を返すメソッド[{4}]を特定できません。"),
    DOMA4074("メッセージコード[{0}]が次の例外により生成されます。{1}"),
    DOMA4076("パラメータの型は配列型でなければいけません。"),
    DOMA4078("パラメータの数は0でなければいけません。"),
    DOMA4079("クラス[{0}]のソースファイルの生成に失敗しました。原因は次のものです。{1}"),
    DOMA4080("クラス[{0}]に適切なパラメータを持つpublicなコンストラクタがみつかりません。コンストラクタはorg.seasar.doma.jdbc.Config型の1つのパラメータを持つか、もしくはorg.seasar.doma.jdbc.Config型と委譲元のDaoの型の2つのパラメータを持たねばいけません。"),
    DOMA4081("クラス[{0}]に、このメソッドと同じシグニチャをもつpublicなメソッドがみつかりません。"),
    DOMA4084("プロパティ[{0}]が、エンティティクラス[{1}]に見つかりません。"),
    DOMA4085("プロパティ[{0}]が、エンティティクラス[{1}]に見つかりません。"),
    DOMA4086("アノテーション[{0}]とアノテーション[{1}]が競合しています。これらは同じフィールドに注釈できません。"),
    DOMA4088("@Idもしくは@Versionを注釈する場合、falseを指定してはいけません。"),
    DOMA4089("@Idもしくは@Versionを注釈する場合、falseを指定してはいけません。"),
    DOMA4090("注釈プロセッサ[{0}]でクラス[{1}]の処理を開始しました。"),
    DOMA4091("注釈プロセッサ[{0}]でクラス[{1}]の処理を終了しました。"),
    DOMA4092("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。詳細は次のものです。{4} SQL[{1}]。"),
    DOMA4093("@Versionは数値のプリミティブ型もしくはNumberのサプタイプのプロパティに対してのみ有効です。"),
    DOMA4095("@GeneratedValueは数値のプリミティブ型もしくはNumberのサプタイプのプロパティに対してのみ有効です。"),
    DOMA4096("クラス[{0}]は、永続対象の型としてサポートされていません。"),
    DOMA4097("戻り値のクラスは、[{0}]でなければいけません。"),
    DOMA4098("@Outが注釈されたパラメータの型は、org.seasar.doma.jdbc.Referenceでなければいけません。"),
    DOMA4100("Referenceの実型引数の型[{0}]はサポートされていません。"),
    DOMA4101("@Inが注釈されるパラメータとして型[{0}]はサポートされていません。"),
    DOMA4102("型[{0}]は永続対象としてサポートされていません。"),
    DOMA4103("型[{0}]をパラメータにもつ非privateなコンストラクタが見つかりません。コンストラクタを定義するか、ファクトリメソッドを利用したい場合は@DomainのfactoryMethod属性にメソッド名を指定してください。"),
    DOMA4104("アクセッサメソッド[{0}]が見つかりません。アクセッサメソッドは、型[{1}]を戻り値とする非privateで引数なしのインスタンスメソッドでなければいけません。"),
    DOMA4105("クラスまたは列挙型以外には注釈できません"),
    DOMA4106("ファクトリメソッド[{0}]が見つかりません。ファクトリメソッドは、型[{1}]を戻り値とし型[{2}]をパラメータにもつ、非privateなstaticメソッドでなければいけません。ファクトリメソッドを定義するか、ファクトリメソッドが不要な場合は@DomainのfactoryMethodに\"new\"と指定しコンストラクタを定義してください。"),
    DOMA4107("@Domainを注釈したクラスには型パラメータを定義できません。"),
    DOMA4108("Referenceには実型引数が必須です。"),
    DOMA4109("戻り値であるjava.lang.Iterableのサブタイプ[{0}]には実型引数が必須です。"),
    DOMA4110("IterationCallback型のパラメータ[{0}]には型パラメータが必須です。"),
    DOMA4111("@InOutが注釈されたパラメータの型は、org.seasar.doma.jdbc.Referenceでなければいけません。"),
    DOMA4112("パラメータの型[{0}]をワイルカード型にしてはいけません。"),
    DOMA4113("戻り値の型[{0}]をワイルカード型にしてはいけません。"),
    DOMA4114("式[{0}]（[{1}]番目の文字付近）に含まれる変数[{2}]の型[{3}]にインスタンスフィールド[{4}]が見つかりません。"),
    DOMA4115("式[{0}]（[{1}]番目の文字付近）に含まれるコンストラクタ[{2}]が見つかりません。"),
    DOMA4116("式[{0}]（[{1}]番目の文字付近）に含まれる比較演算子[{2}]の左被演算子[{3}]の型[{4}]と右被演算子[{5}]の型[{6}]が異なっています。"),
    DOMA4117("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の左被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4118("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の右被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4119("式[{0}]（[{1}]番目の文字付近）に含まれる論理演算子[{2}]の被演算子[{3}]の型[{4}]がboolean/Boolean型ではありません。"),
    DOMA4120("式[{0}]（[{1}]番目の文字付近）に含まれる算術演算子[{2}]の左被演算子[{3}]の型[{4}]が数値型ではありません。"),
    DOMA4121("式[{0}]（[{1}]番目の文字付近）に含まれる算術演算子[{2}]の右被演算子[{3}]の型[{4}]が数値型ではありません。"),
    DOMA4122("SQLファイル[{0}]の妥当検査に失敗しました。メソッドのパラメータ[{1}]がSQLファイルで参照されていません。"),
    DOMA4124("エンティティクラスは非privateな引数なしのコンストラクタを持たねばなりません。"),
    DOMA4125("@OriginalStatesが重複しています。@OriginalStatesが注釈されたフィールドはクラス階層中に1つでなければいけません。"),
    DOMA4126("文字の連結を行う場合、式[{0}]（[{1}]番目の文字付近）に含まれる演算子[{2}]の右被演算子[{3}]の型[{4}]はString/Character/charのいずれかでなければいけません。数値の加算を行う場合、両被演算子は数値型でなければいけません。"),
    DOMA4127("式[{0}]（[{1}]番目の文字付近）に含まれるコンストラクタ[{2}]を特定できません。"),
    DOMA4132("@DomainのfactoryMethod要素の値が\"new\"の場合、クラスはabstractであってはいけません。"),
    DOMA4135("@OriginalStatesが注釈されたフィールドの型はエンティティのクラス[{0}]と同じでなければいけません。"),
    DOMA4138("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]が見つかりません。"),
    DOMA4139("式[{0}]（[{1}]番目の文字付近）に含まれる比較演算子[{2}]の被演算子にnullリテラルは使用できません。"),
    DOMA4140("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%if ...*/の式[{4}]が型[{5}]として評価されましたが、boolean/Boolean型でなければいけません。SQL[{1}]"),
    DOMA4141("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。--elseif ...--の式[{4}]が型[{5}]として評価されましたが、boolean/Boolean型でなければいけません。SQL[{1}]"),
    DOMA4143("SQLファイル[{0}]の取得ができません。原因は次のものです。{1}"),
    DOMA4144("ディレクトリ[{0}]の子ファイルを認識できませんでした。"),
    DOMA4145("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]が見つかりません。"),
    DOMA4146("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]のpublicで戻り値を返すstaticメソッド[{3}]が見つかりません。"),
    DOMA4147("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]のpublicで戻り値を返すstaticメソッド[{3}]を特定できません。"),
    DOMA4148("式[{0}]（[{1}]番目の文字付近）に含まれるクラス[{2}]にstaticフィールド[{3}]が見つかりません。"),
    DOMA4149("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%for ...*/の式[{4}]が型[{5}]として評価されましたが、java.lang.Iterable型でなければいけません。SQL[{1}]"),
    DOMA4150("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。/*%for ...*/の式[{4}]の型[{5}]の実型引数が不明です。SQL[{1}]"),
    DOMA4153("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。バインド変数[{4}]に対応するパラメータの型は基本型もしくはドメインクラスでなければいけません。しかし、実際の型は[{5}]です。型を間違えていませんか？もしくはフィールドアクセスやメソッド呼び出しの記述を忘れていませんか？SQL[{1}]"),
    DOMA4154("戻り値のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4155("戻り値のjava.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4156("戻り値のjava.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4157("java.util.Listに対する実型引数のエンティティクラス[{0}]は抽象型であってはいけません。"),
    DOMA4158("IterationCallbackの2番目の実型引数に抽象型のエンティティクラス[{0}]は指定できません。"),
    DOMA4159("java.lang.Iterableのサブタイプには実型引数が必須です。"),
    DOMA4160("java.lang.Iterableのサブタイプをワイルカード型にしてはいけません。"),
    DOMA4161("SQLファイル[{0}]の妥当検査に失敗しました（[{2}]行目[{3}]番目の文字付近）。括弧の前に位置するバインド変数[{4}]に対応するパラメータの型は基本型もしくはドメインクラスを要素としたjava.lang.Iterableのサブタイプでなければいけません。しかし、実際の型は[{5}]です。型を間違えていませんか？もしくはフィールドアクセスやメソッド呼び出しの記述を忘れていませんか？。SQL[{1}]"),
    DOMA4163("ユーザー定義の設定クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4164("ユーザー定義の設定クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4166("エンティティリスナークラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4167("エンティティリスナークラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4168("org.seasar.doma.jdbc.id.TableIdGeneratorの実装クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4169("org.seasar.doma.jdbc.id.TableIdGeneratorの実装クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4170("org.seasar.doma.jdbc.id.SequenceIdGeneratorの実装クラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4171("org.seasar.doma.jdbc.id.SequenceIdGeneratorの実装クラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4172("戻り値の型はvoidでなければいけません。"),
    DOMA4173("パラメータの数は0でなければいけません。"),
    DOMA4174("列挙型以外には注釈できません"),
    DOMA4176("アクセッサメソッド[{0}]が見つかりません。アクセッサメソッドは、型[{1}]を戻り値とする非privateで引数なしのインスタンスメソッドでなければいけません。"),
    DOMA4177("ファクトリメソッド[{0}]が見つかりません。ファクトリメソッドは、型[{1}]を戻り値とし型[{2}]をパラメータにもつ、非privateなstaticメソッドでなければいけません。"),
    DOMA4178("@EnumDomainが注釈された列挙型[{0}]は指定できません。"),
    DOMA4179("@Domainが注釈されたクラスはトップレベルのクラスでなければいけません。"),
    DOMA4180("@EnumDomainが注釈された列挙型はトップレベルのクラスでなければいけません。"),
    /** SQLファイルに埋め込み変数コメントが含まれていることを示す警告メッセージ */
    DOMA4181("SQLファイル[{0}]に埋め込み変数コメントが含まれています。バッチの中で実行されるSQLは一定であるため、埋め込み変数コメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4181)と注釈してください。"),
    /** SQLファイルに条件コメントが含まれていることを示す警告メッセージ */
    DOMA4182("SQLファイル[{0}]に条件コメントが含まれています。バッチの中で実行されるSQLは一定であるため、条件コメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4182)と注釈してください。"),
    /** SQLファイルに繰り返しコメントが含まれていることを示す警告メッセージ */
    DOMA4183("SQLファイル[{0}]に繰り返しコメントが含まれています。バッチの中で実行されるSQLは一定であるため、繰り返しコメントにより動的なSQLを発行しようとしても意図したSQLにならない可能性があります。この警告を抑制するには、メソッドに@Suppress(message = Message.DOMA4183)と注釈してください。"),
    DOMA4184("列挙型に@Domainを注釈する場合、factoryMethod属性に\"new\"は指定できません（\"new\"はコンストラクタで生成することを示します）。staticで非privateなファクトリメソッドの名前を指定してください。"),
    DOMA4185(" ... /** SQLが長すぎるため最初の{0}文字のみを表示しています。 */"),
    DOMA4186("java.util.Listに対する実型引数の型[{0}]はサポートされていません。サポートされている型は次のものです。基本型、ドメインクラス、エンティティクラス、java.util.Map<String, Object>。"),
    DOMA4187("@Daoが注釈されたインタフェースは2つ以上のインタフェースをextendsできません。"),
    DOMA4188("@Daoが注釈されたインタフェースは@Daoが注釈されてないインタフェース[{0}]をextendsできません。"),
    DOMA4189("式[{0}]（[{1}]番目の文字付近）の関数[{2}]の解決に失敗しました。注釈処理のオプションexpr.functionsに指定されたクラス[{3}]が見つかりません。"),
    DOMA4190("式[{0}]（[{1}]番目の文字付近）の関数[{2}]の解決に失敗しました。注釈処理のオプションexpr.functionsに指定されたクラス[{3}]はorg.seasar.doma.expr.ExpressionFunctionsのサブタイプでなければいけません。"),
    DOMA4191("@ExternalDomainはorg.seasar.doma.jdbc.domain.DomainConverterのサブタイプにのみ注釈できます。"),
    DOMA4192("@ExternalDomainを注釈したクラスは抽象型であってはいけません。クラス[{0}]は抽象型です。"),
    DOMA4193("@ExternalDomainを注釈したクラスは引数なしのpublicなコンストラクタを持たなければいけません。クラス[{0}]には引数なしのpublicなコンストラクタが見つかりません。"),
    DOMA4194("org.seasar.doma.jdbc.domain.DomainConverterの第2型引数に指定された型[{0}]は永続対象としてサポートされていません。"),
    DOMA4195("@EnumDomainが注釈された列挙型[{0}]はorg.seasar.doma.jdbc.domain.DomainConverterの第2型引数に指定できません。"),
    DOMA4196("型[{0}]が@EnumDomainで注釈されていません。"),
    DOMA4197("org.seasar.doma.jdbc.domain.DomainConverterの第1型引数に指定された型[{0}]のパッケージがデフォルトパッケージです。サポートされていません。"),
    DOMA4198("@ExternalDomainが注釈されたクラスはトップレベルでなければいけません。"),
    DOMA4199("org.seasar.doma.jdbc.domain.DomainConverterの第1型引数に指定された型[{0}]はトップレベルでなければいけません。"),
    DOMA4200("注釈処理のオプション domain.converters で指定されたクラス[{0}]が見つかりません。"),
    DOMA4201("注釈処理のオプション domain.converters で指定されたクラス[{0}]に@DomainConvertersが注釈されていません。"),

    // other
    DOMA5001("JDBCドライバがロードされていない可能性があります。JDBCドライバをロードするには、クラスパスが通されたMETA-INF/services/java.sql.DriverファイルにJDBCドライバのクラスの完全修飾名を記述してください。 ex) oracle.jdbc.driver.OracleDriver"),
    DOMA5002("urlプロパティが設定されていません。"), ;

    private final String messagePattern;

    private Message(String messagePattern) {
        this.messagePattern = messagePattern;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMessagePattern() {
        return messagePattern;
    }

    @Override
    public String getMessage(Object... args) {
        String simpleMessage = getSimpleMessageInternal(args);
        String code = name();
        return "[" + code + "] " + simpleMessage;
    }

    @Override
    public String getSimpleMessage(Object... args) {
        return getSimpleMessageInternal(args);
    }

    protected String getSimpleMessageInternal(Object... args) {
        try {
            ResourceBundle bundle = ResourceBundle
                    .getBundle(MessageResourceBundle.class.getName());
            String code = name();
            String pattern = bundle.getString(code);
            return MessageFormat.format(pattern, args);
        } catch (Throwable throwable) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            return "[DOMA9001] Failed to get a message because of following error : "
                    + sw;
        }
    }
}
