package com.apl.android_774ist.service.model

import com.google.gson.annotations.SerializedName

data class GroupMemberInfoResult(
    var groupName: String? = null,
    @SerializedName("memberInfo")
    var memberInfoList: List<MemberInfo>? = null
) {
    data class MemberInfo(
        var name: String? = null,
        var nameKana: String? = null,
        var channelID: String? = null,
        var channelURL: String? = null,
        var twitterURL: String? = null
    )
}