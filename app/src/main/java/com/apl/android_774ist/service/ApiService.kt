package com.apl.android_774ist.service

import com.apl.android_774ist.service.model.ScheduleResult
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("schedule?apl=android")
    fun getSchedule(): Call<ScheduleResult>
}