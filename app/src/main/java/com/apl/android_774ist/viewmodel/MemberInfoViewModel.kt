package com.apl.android_774ist.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MemberInfoViewModel @ViewModelInject constructor(application: Application) :
    AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "実装予定\nバージョンアップをお待ちください..."
    }
    val text: LiveData<String> = _text
}