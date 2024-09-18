package com.example.airportx


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.airportx.databinding.ItemBinding


class AirFlyAdapter(var data: AirportData, var MainThis : MainActivity) : RecyclerView.Adapter<AirFlyAdapter.AirFlyViewHolder>() {
    inner class AirFlyViewHolder(view: ItemBinding) : RecyclerView.ViewHolder(view.root) {
        val ivAirLineLogo = view.ivAirLineLogo
        val tvAirLineCode = view.tvAirLineCode
        val tvAirLineName = view.tvAirLineName
        val tvAirLineNum = view.tvAirLineNum
        val tvAirPlaneType = view.tvAirPlaneType
        val tvExpectTime = view.tvExpectTime
        val tvRealTime = view.tvRealTime
        val tvAirBoardingGate = view.tvAirBoardingGate
        val tvAirFlyDelayCause = view.tvAirFlyDelayCause
        val tvAirFlyStatus = view.tvAirFlyStatus
        val btnAirLineUrl = view.btnAirLineUrl
        val tvUpAirportCode = view.tvUpAirportCode
        val tvUpAirportName = view.tvUpAirportName



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirFlyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AirFlyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.InstantSchedule.size
    }

    override fun onBindViewHolder(holder: AirFlyViewHolder, position: Int) {
        var item = data.InstantSchedule[position]
        holder.ivAirLineLogo.load(item.airLineLogo)
        holder.tvAirLineCode.text = "AirLineCode: " +  item.airLineCode
        holder.tvAirLineName.text = "AirLineName: " + item.airLineName
        holder.tvAirLineNum.text = "AirLineNum: " + item.airLineNum
        holder.tvAirPlaneType.text = "AirPlaneType: " + item.airPlaneType
        holder.tvExpectTime.text = "ExpectTime: " + item.expectTime
        holder.tvRealTime.text = "RealTime: " + item.realTime
        holder.tvAirBoardingGate.text = "AirBoardingGate: " + item.airBoardingGate
        holder.tvAirFlyDelayCause.text = "AirFlyDelayCause: " + item.airFlyDelayCause
        holder.tvAirFlyStatus.text = "AirFlyStatus: " + item.airFlyStatus
        holder.btnAirLineUrl.setOnClickListener {
            openWebPage(item.airLineUrl)

        }

        holder.tvUpAirportCode.text = "UpAirportCode: " + item.upAirportCode
        holder.tvUpAirportName.text = "UpAirportName: " + item.upAirportName
    }



    private fun openWebPage(url: String) {


            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(MainThis, intent, null)
//            var intent = Intent(Intent.ACTION_VIEW)
//
//
//// 设置要打开的 URL
//            intent.setData(Uri.parse(url))
//
//
//// 确保有应用可以处理这个 Intent
//
//            context.startActivity(intent)

//            val intent = Intent(Intent.ACTION_VIEW).apply {
//                data = Uri.parse(url)
//
//            }
//            //val intent = Intent(Intent.ACTION_VIEW)
//            //intent.addCategory(Intent.CATEGORY_BROWSABLE)
//            startActivity(context, intent, null)






    }
}