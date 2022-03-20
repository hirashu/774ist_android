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

    companion object{
        private const val API_URL = "https://hirashu.net/api_774inc-Schedule/"
    }
    val dataList: MutableLiveData<List<Schedule>> = MutableLiveData();
    private val mClient = Client()

    fun getScheduleDataTask() {
        //リクエストURIを作成して、データを取得する
        mClient.createService(API_URL).getSchedule().enqueue(object :
            Callback<ScheduleResult> {

            //非同期処理
            override fun onResponse(
                call: Call<ScheduleResult>,
                response: Response<ScheduleResult>
            ) {
                Log.d("TAG", "onResponse")

                if (response.isSuccessful) {
                    //ステータスコードが200：OK.データも取得済み
                    dataList.value = ScheduleMapper().mapper(response.body())
                } else {
                    //ステータスコードが200以外の処理
                    dataList.value = emptyList()
                }
            }
            override fun onFailure(call: Call<ScheduleResult>, t: Throwable) {
                Log.d("TAG", "onFailure")
            }
        })
    }
}