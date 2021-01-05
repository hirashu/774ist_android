package com.apl.android_774ist.service.model

import com.apl.android_774ist.const.Group774Inc
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
    var publishedAt : Date? =null
    var scheduledStartTime : Date? =null
    var actualStartTime :Date? =null
    //将来的になくすパラメータ
    var isVisibleDay:Boolean =false
    var isVisibleTime:Boolean =false
}