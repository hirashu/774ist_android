package com.apl.android_774ist.service.model

data class GroupMemberInfo(
    var groupName: String? = null,
    var memberInfoList: List<MemberInfo>? = null
) {
    data class MemberInfo(
        var name: String? = null,
        var nameKana: String? = null,
        var imageId: Int? = null,
        var channelURL: String? = null,
        var twitterURL: String? = null
    )
}