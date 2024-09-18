package com.example.airportx

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airportx.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var myAirportReport : AirportData
    lateinit var viewModel: RateViewModel

    // 定義協程作用域
    private val job = SupervisorJob()
    val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val updateTime = 3 * 60 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAirportReport = Gson().fromJson(MyJson.Data, AirportData::class.java)
        binding.rvFly.setHasFixedSize(true)
        binding.rvFly.layoutManager = LinearLayoutManager(this)
        binding.rvFly.adapter = AirFlyAdapter(myAirportReport, this)

        binding.btnFly.setOnClickListener {
            binding.llFly.visibility = View.VISIBLE
            binding.llRate.visibility = View.GONE
        }

        val viewModel = ViewModelProvider(this).get(RateViewModel::class.java)
        viewModel.name_001.observe(this, Observer {
            binding.tv001.text = it
        })
        viewModel.name_002.observe(this, Observer {
            binding.tv002.text = it
        })
        viewModel.name_003.observe(this, Observer {
            binding.tv003.text = it
        })
        viewModel.value_001.observe(this, Observer {
            binding.tv001Value.text = it.toString()
        })
        viewModel.value_002.observe(this, Observer {
            binding.tv002Value.text = it.toString()
        })
        viewModel.value_003.observe(this, Observer {
            binding.tv003Value.text = it.toString()
        })


        binding.btnRate.setOnClickListener {
            binding.llFly.visibility = View.GONE
            binding.llRate.visibility = View.VISIBLE

        }
        CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                val apiKey = "YOUR_API_KEY"
                val baseCurrency = "USD"

                val url = "https://api.currencyapi.com/v3/latest?apikey=cur_live_HCiQhtUYx1CW3COn9PDut5p6x5l6faXd6QYM9G7J&currencies=EUR%2CUSD%2CCAD"
                val connection = URL(url).openConnection() as HttpURLConnection

                try {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = reader.readText()
                    reader.close()

                    val jsonResponse = JSONObject(response)
                    val rates = jsonResponse.getJSONObject("data")

                    println("Exchange rates for base currency $baseCurrency:")
                    val EURValue = "EUR: ${rates.getJSONObject("EUR").getString("value")}"
                    val USDValue = "USD: ${rates.getJSONObject("USD").getString("value")}"
                    val CADValue = "CAD: ${rates.getJSONObject("CAD").getString("value")}"

                    viewModel.name_001.postValue("USD")
                    viewModel.name_002.postValue("EUR")
                    viewModel.name_003.postValue("CAD")
                    viewModel.value_001.postValue(USDValue.substring(5).toFloat())
                    viewModel.value_002.postValue(EURValue.substring(5).toFloat())
                    viewModel.value_003.postValue(CADValue.substring(5).toFloat())

                } finally {
                    connection.disconnect()
                }
                delay(updateTime.toLong())
            }

        }

    }



}