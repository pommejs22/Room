package com.example.training3

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao // データベースにアクセスする為のメソッドを定義するクラス（データベースから値を取り出す時に使用する）DBへのアクセスの前準備
interface OnepieceDao {
    //　※suspendを関数につけることで、その関数はメインスレッドをブロックしてくれる。
    @Query("select * FROM onepiecelist")
     fun getAll(): List<Onepiece> // メモリストが入ったライブデータ（Roomが自動でテーブル内容に変更が生じた時に再取得してくれる）

    @Insert // データを追加するための処理
    fun insert(onepiecelist: kotlin.collections.ArrayList<com.example.training3.Onepiece>) //挿入

    @Query("DELETE FROM onepiecelist")
    fun deleteAll()
    // コルーチン機能を使ってDAOクエリを非同期にすることが出来る


}