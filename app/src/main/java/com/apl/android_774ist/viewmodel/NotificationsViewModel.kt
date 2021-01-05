package com.apl.android_774ist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "実装予定\nバージョンアップをお待ちください"
    }
    val text: LiveData<String> = _text
}