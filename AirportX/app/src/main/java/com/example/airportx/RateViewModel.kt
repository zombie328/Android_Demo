package com.example.airportx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RateViewModel : ViewModel() {
    var name_001 = MutableLiveData<String>()
    var name_002 = MutableLiveData<String>()
    var name_003 = MutableLiveData<String>()

    var value_001 = MutableLiveData<Float>()
    var value_002 = MutableLiveData<Float>()
    var value_003 = MutableLiveData<Float>()

    var l_name_001: String = ""
    var l_name_002: String = ""
    var l_name_003: String = ""


    var l_value_001: Float = 0.0F
    var l_value_002: Float = 0.0F
    var l_value_003: Float = 0.0F


    fun myRequest() {
        CoroutineScope(Dispatchers.IO).launch {


        }
    }
}


