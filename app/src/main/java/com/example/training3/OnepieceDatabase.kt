package com.example.training3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// エンティティとDAOをまとめたもの
// exportSchema = false については　http://heppoen.seesaa.net/article/480674888.html　を参照。
@Database(entities = [Onepiece::class], version = 1, exportSchema = false) //RoomDatabase を拡張した抽象クラスである  OnepieceDatabase を生成。（データベースにアクセスする時に使う）
abstract class OnepieceDatabase : RoomDatabase() {

    //onepieceDao.ktを継承したメソッドここでデータとSQLを実行する記述をメインに記載してもOK

    abstract fun onepieceDao(): OnepieceDao

//    companion object { //クラス内に作成されるシングルトン
//        @Volatile //
//        private var INSTANCE: OnepieceDatabase? = null
//        fun getDatabase(context: Context): OnepieceDatabase {
//            return INSTANCE ?: synchronized(this) {
//                // 1度に1つのスレッドしかアクセス出来ない
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    OnepieceDatabase::class.java,
//                    "OnepieceDatabase"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//
//        }
//    }
}