package com.apl.android_774ist.viewmodel

import android.app.Application
import android.content.Intent
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.apl.android_774ist.R
import com.apl.android_774ist.service.model.GroupMemberInfo
import com.apl.android_774ist.service.repository.GroupMemberInfoRepository

class MemberInfoViewModel @ViewModelInject constructor(application: Application) :
    AndroidViewModel(application) {

    var groupMemberInfoRepository: GroupMemberInfoRepository = GroupMemberInfoRepository()

    //監視対象のLiveData
    val groupMemberListLiveData: LiveData<List<GroupMemberInfo>>
        get() = groupMemberInfoRepository.dataList //ここの実装が気に入らない

    //初期時に実施される
    init {
        groupMemberInfoRepository.getGroupMemberInfoTask()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("srcImageId")
        fun srcImageId(view: ImageView, imageId: Int?) {
            imageId?.let {
                view.setImageResource(it)
            }
        }
    }
}
