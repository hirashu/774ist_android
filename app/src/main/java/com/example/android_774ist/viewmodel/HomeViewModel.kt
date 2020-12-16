package com.example.android_774ist.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android_774ist.const.Group774Inc
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.repository.ScheduleRepository
import com.example.android_774ist.util.DateUnit
import org.w3c.dom.Text
import java.util.*
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(application: Application) :
    AndroidViewModel(application) {

    var scheduleRepository: ScheduleRepository = ScheduleRepository()
        @Inject set

    //監視対象のLiveData
    private var mScheduleListLiveData: MutableLiveData<List<Schedule>> = MutableLiveData()
    val scheduleListLiveData: LiveData<List<Schedule>>
        get() = scheduleRepository.dataList //ここの実装が気に入らない

    //初期時に実施される
    init {
        mScheduleListLiveData.value = scheduleRepository.getScheduleData().value
        //todo 運用がscheduleRepository.getScheduleData().value　と変らないので気に入らない
    }

    //fixme 本来ならソートしたモデルでフィルターを実行する(マッパーでソートしたほうがいい？？)
    fun groupScheduleList(group: Group774Inc): List<Schedule>? {
        return if (group == Group774Inc.ALL) {
            scheduleRepository.dataList.value?.sortedBy { it.scheduledStartTime }
        } else {
            scheduleRepository.dataList.value?.filter { it.group == group }?.sortedBy { it.scheduledStartTime }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                Glide.with(view.context)
                    .load(imageUrl).into(view)
            }
        }

        @SuppressLint("SetTextI18n")
        @JvmStatic
        @BindingAdapter("formHmmDate")
        fun formHmmDate(view: TextView,date: Date?) {
            if (date != null) {
                view.text= DateUnit().formHmmDate(date) + " ~"
            }
        }
    }
}