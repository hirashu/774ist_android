package com.example.android_774ist.service.repository

import android.util.Log
import com.example.android_774ist.service.ApiService
import com.example.android_774ist.service.Client
import com.example.android_774ist.service.mapper.scheduleMapper
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.model.ScheduleResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class scheduleRepository {
    //APIから値を受け取る処理(OK,NGで分岐する)
    private val apiUrl="https://hirashu.net/api_774inc-Schedule/"

    fun getScheduleData():List<Schedule>{
        var dataList = listOf<Schedule>()
        //リクエストURIを作成して、データを取得する
        Client().createService(apiUrl).getSchedule().enqueue(object :
            Callback<List<ScheduleResult.Item>> {

            //非同期処理
            override fun onResponse(call: Call<List<ScheduleResult.Item>>, response: Response<List<ScheduleResult.Item>>) {
                Log.d("TAGres","onResponse")

                //ステータスコードが200：OKなので、ここではちゃんと通信できたよ
                if (response.isSuccessful) {
                     dataList=scheduleMapper().mapper(response.body())
                } else {
                    //もしダメだった時の処理
                }
            }
            override fun onFailure(call: Call<List<ScheduleResult.Item>>, t: Throwable) {
                Log.d("TAGres","onFailure")
            }
        })
        return dataList
    }

}