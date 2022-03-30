package com.example.training3

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Onepiecelist")// RoomはOnepieceというテーブルを作ってくれる（データベースのテーブルを表すクラス）
 class Onepiece(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,// IDプロパティをPrimaryKeyとして自動で採番してくれる、nullを許容すると
    var imageId: Int, // アイコン /
    var title: String, // 名言
    var name: String, // 名前
) : Serializable

