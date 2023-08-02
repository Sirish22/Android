package com.sirish.vehiclewear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sirish.vehiclerentalapplication.entity.Vehicle
import com.sirish.vehiclewear.adapter.VehicleAdapter
import com.sirish.vehiclewear.repository.VehicleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductActivity : WearableActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var vehicles: MutableList<Vehicle>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // Enables Always-on
        setAmbientEnabled()

        recyclerView = findViewById(R.id.RvRecyclerView)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vehicle = VehicleRepository()
                val response = vehicle.getVehicle()
                if (response.success == true) {
                    //put all the vehicle details in lstvehicle

                    val lstVehicle = response.data
                    if (lstVehicle!= null) {
                        withContext(Dispatchers.Main) {

                            recyclerView.layoutManager = LinearLayoutManager(this@ProductActivity, LinearLayoutManager.VERTICAL,false)
                            recyclerView.adapter = VehicleAdapter(this@ProductActivity, response.data!! as MutableList<Vehicle>)
                        }

                    }


                }
            }
            catch (ex : Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ProductActivity, "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


}