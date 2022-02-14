package com.apl.android_774ist.service.model

data class GroupMemberInfo(
    var groupName: String? = null,
    var MemberInfoList: List<MemberInfo>? = null
) {
    data class MemberInfo(
        var name: String? = null,
        var image: String? = null,
        var introduction: String? = null,
        var channelId: String? = null,
        var twitterID: String? = null
    )
}