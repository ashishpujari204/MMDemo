package com.ashish.demo.inputurl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UrlInputViewModel : ViewModel() {

    private val _urlLiveData = MutableLiveData<String>()

    fun setUrl(url: String) {
        _urlLiveData.value = url
    }

    fun getUrl(): LiveData<String> = _urlLiveData
}