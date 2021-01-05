package com.apl.android_774ist.viewmodel

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
import com.apl.android_774ist.const.Group774Inc
import com.apl.android_774ist.service.model.Schedule
import com.apl.android_774ist.service.repository.ScheduleRepository
import com.apl.android_774ist.util.DateUnit
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
    fun groupScheduleList(group: Group774Inc): List<Schedule> {
        return if (group == Group774Inc.ALL) {
            setVisibleTime(scheduleRepository.dataList.value)
        } else {
            setVisibleTime(scheduleRepository.dataList.value?.filter { it.group == group })
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
        @SuppressLint("SetTextI18n")
        @JvmStatic
        @BindingAdapter("formMMddDate")
        fun formMMddDate(view: TextView,date: Date?) {
            if (date != null) {
                view.text= DateUnit().formMMddDate(date)
            }
        }
        @SuppressLint("SetTextI18n")
        @JvmStatic
        @BindingAdapter("visibility")
        fun visibility(view: TextView,visibility: Boolean) {
            if (visibility)  view.visibility=TextView.VISIBLE else view.visibility=TextView.GONE
        }

        //放送時間の時間や日付の表示設定
        fun setVisibleTime(schedule:List<Schedule>?):List<Schedule>{
            schedule ?:return emptyList()
            var scheduleDay: String? =null
            var scheduleTime:String? =null

            schedule.forEach {it->
                val day=DateUnit().formMMddDate(it.scheduledStartTime)
                val time = DateUnit().formHmmDate(it.scheduledStartTime)
                if(day==scheduleDay) {
                    //日にちが同じ
                    it.isVisibleDay = false
                }else{
                    scheduleDay=day
                    it.isVisibleDay = true
                }
                if(time==scheduleTime){
                    //放送時間が同じ
                    it.isVisibleTime=false}
                else{
                    scheduleTime=time
                    it.isVisibleTime=true
                }
            }
            return schedule
        }
    }
}