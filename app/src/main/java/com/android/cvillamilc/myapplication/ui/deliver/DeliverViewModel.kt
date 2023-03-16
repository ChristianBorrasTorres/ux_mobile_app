package com.android.cvillamilc.myapplication.ui.deliver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeliverViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Deliver"
    }
    val text: LiveData<String> = _text
}