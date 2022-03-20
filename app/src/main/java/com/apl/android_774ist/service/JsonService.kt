package com.apl.android_774ist.service

import com.apl.android_774ist.service.model.GroupMemberInfoResult
import retrofit2.Call
import retrofit2.http.GET

interface JsonService {
    @GET("memberInfo.json")
    fun getMemberInfo(): Call<List<GroupMemberInfoResult>>
}