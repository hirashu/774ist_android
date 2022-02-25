package com.apl.android_774ist.service.mapper

import com.apl.android_774ist.const.memberImageId
import com.apl.android_774ist.service.model.GroupMemberInfo
import com.apl.android_774ist.service.model.GroupMemberInfoResult

class GroupMemberInfoMapper {
    fun mapper(results: List<GroupMemberInfoResult>?): List<GroupMemberInfo> {
        results ?: return emptyList()
        return results.mapNotNull {
            GroupMemberInfo().apply {
                groupName = it.groupName ?: return@mapNotNull null
                memberInfoList = it.memberInfoList?.map {
                    GroupMemberInfo.MemberInfo(
                        name = it.name,
                        nameKana = it.nameKana,
                        imageId = memberImageId(it.channelID),
                        channelURL = it.channelURL,
                        twitterURL = it.twitterURL
                    )
                } ?: return@mapNotNull null
            }
        }
    }
}