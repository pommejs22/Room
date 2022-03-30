package com.example.training3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    // lateinitでinterfaceのDao.ktをdaoに継承させ、daoが呼び出されたタイミングで処理を実行
    private lateinit var dao: OnepieceDao

    // lateinitでabstract(抽象クラス)のAnimalDatabase.ktをdbに継承させ、dbが呼び出されたタイミングで処理を実行
    private lateinit var db: OnepieceDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onepiecelist = ArrayList<Onepiece>()
        // member をaddしていく


        for (i in 1..5) {
            when (i) {
                1 -> {
                    onepiecelist.add(
                        Onepiece(
                            imageId = R.drawable.onepiece01_luffy2,
                            title = "海賊王におれはなる！！！！",
                            name = "モンキー・D・ルフィ",
                        )
                    )
                }

                2 -> {
                    onepiecelist.add(
                        Onepiece(
                            imageId = R.drawable.onepiece02_zoro_bandana,
                            title = "背中の傷は剣士の恥だ",
                            name = "ロロノア・ゾロ",
                        )
                    )
                }
                3 -> {
                    onepiecelist.add(
                        Onepiece(
                            imageId = R.drawable.onepiece03_nami,
                            title = "もう背中向けられないじゃないっ!!!!",
                            name = "ナミ",
                        )
                    )
                }
                4 -> {
                    onepiecelist.add(
                        Onepiece(
                            imageId = R.drawable.onepiece05_sanji,
                            title = ".....長い間!!!　くそお世話になりました!!!",
                            name = "サンジ",
                        )
                    )
                }
                5 -> {
                    onepiecelist.add(
                        Onepiece(
                            imageId = R.drawable.onepiece06_chopper,
                            title = "世界で一番偉大な医者がくれた名前だ!!",
                            name = "トニートニー・チョッパー",
                        )
                    )
                }
            }
        }


        // 永続データベースを作成
        // val db = Room.databaseBuilder(applicationContext, OnepieceDatabase::class.java, "database-onepiece").build()
        db = Room.databaseBuilder(this, OnepieceDatabase::class.java, "database-onepiece").build()
        dao = db.onepieceDao()
        var dbOnepieceMember = listOf<Onepiece>()
        // コールチンでサブスレッド（UIに見えないSQLの処理)とメインスレッドの部分を記述する
        GlobalScope.launch(Dispatchers.Main) {
            // サブスレッド(UIには見えないSQLの処理)
            withContext(Dispatchers.IO) {
                dao.let {
                    it.deleteAll()
                    it.insert(onepiecelist)
                }
                dbOnepieceMember = dao.getAll()
            }

            // メインスレッド(UIに出す処理)
            withContext(Dispatchers.Main) {
                val lists = findViewById<ListView>(R.id.custom_list_view)
                val adapter = CustomAdpter(this@MainActivity, dbOnepieceMember as ArrayList<Onepiece>)

                lists.adapter = adapter


                lists.setOnItemClickListener { parent: AdapterView<*>, _: View, position: Int, _: Long ->
                    val item = parent.getItemAtPosition(position) as Onepiece
                    val intent = Intent(this@MainActivity, SubActivity::class.java)

                    val state = Onepiece(item.id, item.imageId, item.title, item.name)

                    intent.putExtra("Onepiece", state)
                    startActivity(intent)
                }
            }
        }
    }
}

//            launch {
//                    db.onepieceDao().deleteAll()
//                }.join()
//
//                // データを保存
//                launch {
//                    db.onepieceDao().insert(Onepiece(0,"",""))
//                }.join()
//
//                launch {
//                    val list: List<Onepiece> = db.onepieceDao().getAll()
//                    println(list)
//                }.join()
//            }



//        // データ一覧の取得
//        val luFfy = Onepiece(R.drawable.onepiece01_luffy2, "海賊王におれはなる！！！！", "モンキー・D・ルフィ")
//        val zoRo = Onepiece(R.drawable.onepiece02_zoro_bandana, "背中の傷は剣士の恥だ", "ロロノア・ゾロ")
//        val naMi = Onepiece(R.drawable.onepiece03_nami, "もう背中向けられないじゃないっ!!!!", "ナミ")
//        val sanJi = Onepiece(R.drawable.onepiece05_sanji, ".....長い間!!!　くそお世話になりました!!!", "サンジ")
//        val chopper = Onepiece(R.drawable.onepiece06_chopper, "世界で一番偉大な医者がくれた名前だ!!", "トニートニー・チョッパー")



//        val onePieceList = arrayListOf<Onepiece>()

//        for (member in memberList) {
//            memberList.add(member)
//        }
//
//
//        for (i in 1..5) {
//            onePieceList.add(Onepiece(0, "", "").apply {
//                when (i) {
//                    1 -> {
//                        this.imageId = R.drawable.onepiece01_luffy2
//                        this.title = "海賊王におれはなる！！！！"
//                        this.name = "モンキー・D・ルフィ"
//                    }
//                    2 -> {
//                        this.imageId = R.drawable.onepiece02_zoro_bandana
//                        this.title = "背中の傷は剣士の恥だ"
//                        this.name = "ロロノア・ゾロ"
//                    }
//                    3 -> {
//                        this.imageId = R.drawable.onepiece03_nami
//                        this.title = "もう背中向けられないじゃないっ!!!!"
//                        this.name = "ナミ"
//                    }
//                    4 -> {
//                        this.imageId = R.drawable.onepiece05_sanji
//                        this.title = ".....長い間!!!　くそお世話になりました!!!"
//                        this.name = "サンジ"
//                    }
//                    5 -> {
//                        this.imageId = R.drawable.onepiece06_chopper
//                        //this.imageId = "チョッパー"
//                        this.title = "世界で一番偉大な医者がくれた名前だ!!"
//                        this.name = "トニートニー・チョッパー"
//                    }
//                }
//
//            })
////
//            // ListViewのインスタンス生成
//            val listView = findViewById<ListView>(R.id.custom_list_view)
//
//            val adapter = CustomAdpter(this, onePieceList)
//            listView.adapter = adapter
//
//
//            //　ボタンクリックイベントリスナー設定
//            listView.setOnItemClickListener { parent: AdapterView<*>, _: View, position: Int, _: Long ->
//
////            Toast.makeText(this@MainActivity,"猫",Toast.LENGTH_LONG).show()
//
//
//                val item = parent.getItemAtPosition(position) as Onepiece
//                val state = Onepiece(item.imageId, item.title, item.name)
//
//
//                Intent(this@MainActivity, SubActivity::class.java).apply {
//                    this.putExtra("onepiece", state)
//                }.also { startActivity(it) }
//                // 次の画面へ遷移
//            }
//        }
//    }
//}
