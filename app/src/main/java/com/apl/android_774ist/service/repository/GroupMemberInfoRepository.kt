package com.apl.android_774ist.service.repository

import androidx.lifecycle.MutableLiveData
import com.apl.android_774ist.service.Client
import com.apl.android_774ist.service.mapper.GroupMemberInfoMapper
import com.apl.android_774ist.service.model.GroupMemberInfo
import com.apl.android_774ist.service.model.GroupMemberInfoResult
import com.apl.android_774ist.service.model.Schedule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GroupMemberInfoRepository @Inject constructor() {

    val dataList: MutableLiveData<List<GroupMemberInfo>> = MutableLiveData();
    private val mClient = Client()

    fun getGroupMemberInfoTask() {
        //リクエストURIを作成して、データを取得する
        mClient.createJsonService().getMemberInfo().enqueue(object :
            Callback<List<GroupMemberInfoResult>> {

            //非同期処理
            override fun onResponse(call: Call<List<GroupMemberInfoResult>>, response: Response<List<GroupMemberInfoResult>>) {
                if (response.isSuccessful) {
                    //ステータスコードが200：OK.データも取得済み
                    dataList.value = GroupMemberInfoMapper().mapper(response.body())
                } else {
                    //ステータスコードが200以外の処理
                    dataList.value = emptyList()
                }
            }
            override fun onFailure(call: Call<List<GroupMemberInfoResult>>, t: Throwable) {
                dataList.value = emptyList() //todo 本来ならnullを返すようにしないといけないな
            }
        })
    }
}
