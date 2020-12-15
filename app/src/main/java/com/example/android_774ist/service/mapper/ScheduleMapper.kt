package com.example.android_774ist.service.mapper

import com.example.android_774ist.const.group774inc
import com.example.android_774ist.const.memberName
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.model.ScheduleResult

class ScheduleMapper {

    fun mapper(results:ScheduleResult?):List<Schedule>{
        val result =results?.items
        result ?:return listOf<Schedule>()
        //結果を詰めなおす
        //todo 配信時間順にソートしてもいいかも
        return result.mapNotNull {
            val snippet=it.snippet?:return@mapNotNull null
            Schedule().apply {
                channelId =snippet.channelId
                distributor = memberName(channelId)
                group= group774inc(channelId)
                broadcastId =it.id
                title =snippet.title
                description =snippet.description
                thumbnailsImgUrl =snippet.thumbnails?.medium?.url
                liveBroadcastContent= snippet.liveBroadcastContent
                scheduledStartTime =it.liveStreamingDetails?.scheduledStartTime
                actualStartTime =it.liveStreamingDetails?.actualStartTime
            }
        }
    }
}