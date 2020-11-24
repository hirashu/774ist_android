package com.example.android_774ist.service

import com.example.android_774ist.service.model.ScheduleResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("schedule")
    fun getSchedule(): Call<List<ScheduleResult.Item>>
}