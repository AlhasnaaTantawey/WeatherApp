package com.example.weatherapp.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.ConditionWeather
import com.example.weatherapp.R
import com.sawaf.weatherappex.tools.inflate

class MyRecyclerViewAdapter(private val list :List<ConditionWeather>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val textViewtemp: TextView =itemView.findViewById(R.id.list_item_design_textView_temp)
        val textViewdesc: TextView =itemView.findViewById(R.id.list_item_design_textView_desc)
        val textViewhours: TextView =itemView.findViewById(R.id.list_item_design_textView_hours)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //inflate
        // that is used to hold list item
        // val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val view=  parent.inflate(R.layout.list_item)
        return MyViewHolder(view)
    }
 
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
 var conditionWeather =list[position]
  holder.textViewtemp.text= conditionWeather.main?.temp.toString()+" C"
        holder.textViewdesc.text= conditionWeather.weather?.get(0)!!.description
        holder.textViewhours.text=conditionWeather.dt_txt
    }

    override fun getItemCount(): Int {
        return list.size
    }
}