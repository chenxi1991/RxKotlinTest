package com.example.a39092.rxjavatest.module.main.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.a39092.rxjavatest.R
import com.example.a39092.rxjavatest.model.bean.ResponseBody
import com.jakewharton.rxbinding2.view.RxView
import java.util.concurrent.TimeUnit

/**
 * @author chenxi
 * *
 * @title RxJavaTest
 * *
 * @date 2017/4/13
 * *
 * @description
 */

class LvMovieAdapter(private val list: ArrayList<ResponseBody.SubjectsBean>, private val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.lv_movie_item, null)
            holder = ViewHolder(convertView)
            convertView!!.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.lvMovieItemName!!.text = list[position].title
        holder.lvMovieItemStar!!.text = list[position].rating!!.stars
        Glide.with(context).load(list[position].images!!.medium).into(holder.lvMovieItemPic!!)
        RxView.clicks(convertView).throttleFirst(1, TimeUnit.SECONDS).subscribe { Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show() }
        return convertView
    }

    internal inner class ViewHolder(view: View) {
        var lvMovieItemPic: ImageView? = null
        var lvMovieItemName: TextView? = null
        var lvMovieItemStar: TextView? = null

        init {
            lvMovieItemPic = view.findViewById(R.id.lv_movie_item_pic) as ImageView?
            lvMovieItemName = view.findViewById(R.id.lv_movie_item_name) as TextView?
            lvMovieItemStar = view.findViewById(R.id.lv_movie_item_star) as TextView?
        }
    }
}
