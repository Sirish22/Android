@file:Suppress("DEPRECATION")

package com.sirish.vehiclewear

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.sirish.vehiclerentalapplication.api.ServiceBuilder
import com.sirish.vehiclewear.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : WearableActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvSignIn: TextView
    private lateinit var linearlayout : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvSignIn = findViewById(R.id.tvSignIn)
        linearlayout = findViewById(R.id.linearlayout)

        tvSignIn.setOnClickListener {
            login()
        }
    }
    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true){
                    ServiceBuilder.token = "Bearer" + response.token
                    startActivity(
                            Intent(this@MainActivity,ProductActivity::class.java)
                    )
                    finish()
                }
                else{
                    withContext(Dispatchers.Main){
                        val snack = Snackbar.make(
                                linearlayout,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                        )
                        snack.setAction("Ok", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }
            }catch (ex : Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Login error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}