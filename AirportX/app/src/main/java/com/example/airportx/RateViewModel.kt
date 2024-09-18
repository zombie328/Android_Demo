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
    var name_004 = MutableLiveData<String>()
    var name_005 = MutableLiveData<String>()
    var name_006 = MutableLiveData<String>()

    var value_001 = MutableLiveData<Float>()
    var value_002 = MutableLiveData<Float>()
    var value_003 = MutableLiveData<Float>()
    var value_004 = MutableLiveData<Float>()
    var value_005 = MutableLiveData<Float>()
    var value_006 = MutableLiveData<Float>()


    fun myRequest() {
        CoroutineScope(Dispatchers.IO).launch {


        }
    }
}


