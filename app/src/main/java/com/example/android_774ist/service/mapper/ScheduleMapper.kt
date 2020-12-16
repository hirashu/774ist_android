package com.example.android_774ist.service.mapper

import com.example.android_774ist.const.group774inc
import com.example.android_774ist.const.memberName
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.model.ScheduleResult
import com.example.android_774ist.util.DateUnit

class ScheduleMapper {

    fun mapper(results:ScheduleResult?):List<Schedule>{
        val result =results?.items
        result ?:return listOf<Schedule>()
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
                //todo scheduledStartTimeはData型で保持までが正しい。ソートはvmで行う感じで
                scheduledStartTime = it.liveStreamingDetails?.scheduledStartTime?.let { it1 ->
                    DateUnit().formHmmDateRFC3339Date(it1)
                }
                actualStartTime =it.liveStreamingDetails?.actualStartTime
            }
        }
    }
}