package com.example.android_774ist.service.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.android_774ist.const.Group774Inc
import java.util.*


class Schedule {
    var channelId:String?=null
    var distributor:String? = null
    var group: Group774Inc? =null
    var broadcastId:String? = null
    var title :String? =null
    var description:String?=null
    var thumbnailsImgUrl:String?=null
    var liveBroadcastContent:String?=null
    var scheduledStartTime : Date? =null
    var actualStartTime :Date? =null
    //将来的になくすパラメータ
    var isVisibleDay:Boolean =false
    var isVisibleTime:Boolean =false
}