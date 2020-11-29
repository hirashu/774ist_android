package com.example.android_774ist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.repository.ScheduleRepository

class HomeViewModel : ViewModel() {

    private val scheduleRepository=ScheduleRepository.instance

    //監視対象のLiveData
    var scheduleListLiveData: MutableLiveData<List<Schedule>> = MutableLiveData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"  /*todo ここでじっそうする*/
    }
    val text: LiveData<String> = _text

    //初期時に実施される
    init {
        scheduleListLiveData.postValue(scheduleRepository.getScheduleData())
    }

}