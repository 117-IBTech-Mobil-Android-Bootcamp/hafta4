package com.patikadev.deneme1.ui.spacex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.deneme1.R
import com.patikadev.deneme1.ui.spacex.dto.Launch

class LaunchAdpater(val launches : List<Launch>, val function : (Launch) -> Unit) : RecyclerView.Adapter<LaunchAdpater.LaunchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return  LaunchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_launch, parent, false))
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {

        val launch = launches[position]
        holder.bind(launch)
    }

    override fun getItemCount() = launches.size


    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val missionName = itemView.findViewById<AppCompatTextView>(R.id.textview_mission_name)
        val launcyear = itemView.findViewById<AppCompatTextView>(R.id.textview_launch_yer)
        val detail = itemView.findViewById<AppCompatTextView>(R.id.textview_details)
        val rocketid = itemView.findViewById<AppCompatTextView>(R.id.rocket_id)
        val rocketType = itemView.findViewById<AppCompatTextView>(R.id.rocket_type)
        val rocketName = itemView.findViewById<AppCompatTextView>(R.id.rocket_name)


        fun bind(launch : Launch){

            missionName.text = launch.missionName
            launcyear.text = launch.year
            detail.text = launch.details
            rocketid.text = launch.rocket.id
            rocketType.text = launch.rocket.type
            rocketName.text = launch.rocket.name

            itemView.setOnClickListener {
                function.invoke(launch)

            }
        }

    }
}


