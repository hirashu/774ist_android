package com.example.android_774ist.service.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


class Schedule {
    var id:String? = null
    var distributor:String? = null
    var title :String? =null
    var channelId:String?=null
    var description:String?=null
    var thumbnailsImgUrl:String?=null
    var liveBroadcastContent:String?=null
    var scheduledStartTime :String? =null
    var actualStartTime :String? =null
}