package com.example.android_774ist.service.model

data class ScheduleResult(
    val items:List<Item>?
) {
    class Item{
        val id:String?=null
        val snippet: Snippet?=null
        val liveStreamingDetails :LiveStreamingDetail?=null
    }

    class Snippet{
        val title :String? =null
        val description:String?=null
        val thumbnails:Thumbnails?=null
        /**TODO ここはenumクラス化するか考える*/
        val liveBroadcastContent:String?=null
        val channelId:String?=null

    }

    class Thumbnails{
        val default:ThumbnailsImg? = null
        val medium:ThumbnailsImg? = null
        val high:ThumbnailsImg? = null
    }

    class ThumbnailsImg {
        val url:String? = null
        val width:Int ?= null
        val height:Int ?= null
    }

    /**動画の配信時間のクラス*/
    class LiveStreamingDetail{
        val scheduledStartTime :Long? =null
        val actualStartTime :String? =null
    }
}