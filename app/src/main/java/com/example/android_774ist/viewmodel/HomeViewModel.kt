package com.example.android_774ist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"  /*todo ここでじっそうする*/
    }
    val text: LiveData<String> = _text

    //todo repositoryから値の取得・更新を行う。リポジトリ作成してからでいいかな

}