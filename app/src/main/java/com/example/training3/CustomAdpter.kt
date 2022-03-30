package com.example.training3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView

class CustomAdpter(content: Context, list: ArrayList<Onepiece>) :
    ArrayAdapter<Onepiece>(content, 0, list),
    ListAdapter {

    private val layoutInflater =
        content.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // レイアウトの設定
        var view = convertView
        if (convertView == null) {
            // レイアウト生成
//            view = LayoutInflater.from(context).inflate(R.layout.row_view, parent, false)
            view = layoutInflater.inflate(R.layout.row_view, parent, false)
        }

        // 一行分のデータを取得
        val data = getItem(position) as Onepiece


        //各Viewの設定
        val imageView = view?.findViewById<ImageView>(R.id.imageId)
//        data?.imageId?.let { imageView?.setImageResource(it) }
        imageView?.setImageResource(data.imageId)

        val title = view?.findViewById<TextView>(R.id.title)
        title?.text = data.title

        val name = view?.findViewById<TextView>(R.id.name)
        name?.text = data.name

        return view!!
    }


}