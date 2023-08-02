package com.sirish.vehiclewear.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirish.vehiclerentalapplication.api.ServiceBuilder
import com.sirish.vehiclerentalapplication.entity.Vehicle
import com.sirish.vehiclewear.R
import com.sirish.vehiclewear.repository.VehicleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers.Main

class VehicleAdapter(
    private val context : Context,
    private val lstVehicles : MutableList<Vehicle>
): RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>(){

    class VehicleViewHolder(view: View): RecyclerView.ViewHolder(view){
        var Vimage : ImageView
        var Vname : TextView
        var Vdetails : TextView
        var Vprice : TextView
        var btnVehicle: TextView
        init {
            Vimage =view.findViewById(R.id.Vimage)
            Vname= view.findViewById(R.id.tvVehicleName)
            Vdetails = view.findViewById(R.id.tvVehicleDetails)
            Vprice = view.findViewById(R.id.tvVehiclePrice)
            btnVehicle = view.findViewById(R.id.tvRent)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.activity_dash,parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = lstVehicles[position]
        Glide.with(context).load("${ServiceBuilder.BASE_URL}${vehicle.vimage}").into(holder.Vimage)
        println("${ServiceBuilder.BASE_URL}${vehicle.vimage}")
        holder.Vname.text = vehicle.vname
        holder.Vdetails.text = vehicle.vdetails
        holder.Vprice.text = vehicle.vprice

        holder.btnVehicle.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {


                val repository = VehicleRepository()
                val response = repository.rent(vehicle)
                if(response.success==true){
                    withContext(Main){
                        Toast.makeText(context, "Vehicle Rented", Toast.LENGTH_SHORT).show()

                    }
                }

            }


        }


    }

    override fun getItemCount(): Int {
        return lstVehicles.size
    }
}

