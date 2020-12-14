package com.example.android_774ist.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.repository.ScheduleRepository
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(application: Application) :
    AndroidViewModel(application) {

    var scheduleRepository: ScheduleRepository = ScheduleRepository()
        @Inject set

    //監視対象のLiveData
    private var mScheduleListLiveData: MutableLiveData<List<Schedule>> = MutableLiveData()
    val scheduleListLiveData: LiveData<List<Schedule>>
        get() = scheduleRepository.getScheduleData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"  /*todo ここでじっそうする*/
    }
    val text: LiveData<String> = _text

    //初期時に実施される
    init {
        mScheduleListLiveData.value = scheduleRepository.getScheduleData().value
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
    }
}