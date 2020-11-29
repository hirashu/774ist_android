package com.example.android_774ist.service.mapper

import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.model.ScheduleResult

class scheduleMapper {

    fun mapper(results:ScheduleResult?):List<Schedule>{
        val result =results?.items
        result ?:return listOf<Schedule>()
        //結果を詰めなおす
        //todo 配信時間順にソートしてもいいかも
        return result.mapNotNull {
            val snippet=it.snippet?:return@mapNotNull null
            Schedule().apply {
                id =it.id
                title =snippet.title
                channelId =snippet.channelId
                description =snippet.description
                thumbnailsImgUrl =snippet.thumbnails?.medium?.url
                liveBroadcastContent= snippet.liveBroadcastContent
                scheduledStartTime =it.liveStreamingDetails?.scheduledStartTime
                actualStartTime =it.liveStreamingDetails?.actualStartTime
            }
        }
    }
}