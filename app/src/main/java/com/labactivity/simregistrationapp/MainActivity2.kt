package com.labactivity.simregistrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.labactivity.simregistrationapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTxtSuccess.showSoftInputOnFocus = false
        binding.editTxtDetails.showSoftInputOnFocus = false

        val passedName = intent.getStringExtra("nameData")
        val passedContact = intent.getStringExtra("contactData")
        val passedSim = intent.getStringExtra("simData")
        val passedAddr = intent.getStringExtra("addrData")

        val details = "$passedName\n\n$passedContact\n\n$passedSim\n\n$passedAddr"

        Toast.makeText(applicationContext, "Sim Registration Complete!", Toast.LENGTH_SHORT).show()

        binding.editTxtDetails.setText(details)
    }
}