package com.gugu.demo.kangfuzhongxin.ui.me

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "张三"
    }
    val text: LiveData<String> = _text
}