package com.apl.android_774ist.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apl.android_774ist.service.Client
import com.apl.android_774ist.service.mapper.ScheduleMapper
import com.apl.android_774ist.service.model.Schedule
import com.apl.android_774ist.service.model.ScheduleResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ScheduleRepository @Inject constructor() {

    private val apiUrl = "https://hirashu.net/api_774inc-Schedule/"

    private val client = Client()

    val dataList: MutableLiveData<List<Schedule>> = MutableLiveData();

    fun getScheduleDataTask() {
        //val dataList: MutableLiveData<List<Schedule>> = MutableLiveData();
        //リクエストURIを作成して、データを取得する
        client.createService(apiUrl).getSchedule().enqueue(object :
            Callback<ScheduleResult> {

            //非同期処理
            override fun onResponse(
                call: Call<ScheduleResult>,
                response: Response<ScheduleResult>
            ) {
                Log.d("TAGres", "onResponse")

                //ステータスコードが200：OK.データも取得済み
                if (response.isSuccessful) {
                    //dataListのリターン後に以下が行われる
                    dataList.value = ScheduleMapper().mapper(response.body())
                } else {
                    //ステータスコードが200以外の処理
                }
            }
            override fun onFailure(call: Call<ScheduleResult>, t: Throwable) {
                Log.d("TAGres", "onFailure")
            }
        })
    }
}