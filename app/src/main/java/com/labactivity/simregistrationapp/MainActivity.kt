package com.labactivity.simregistrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.labactivity.simregistrationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener() {
            val intentScr2 = Intent(this, MainActivity2::class.java)

            val name = binding.editTxtName.text.toString()
            var nameValid = false

            val contactNum = binding.editTxtContact.text.toString()
            var contactValid = false

            val simNet = binding.editTxtSim.text.toString()
            var simValid = false

            val addr = binding.editTxtAddr.text.toString()
            var addrValid = false

            val phoneRegex = "^(09|\\+639)\\d{9}$".toRegex()

            if(name.isNotEmpty()) {
                intentScr2.putExtra("nameData", name)
                nameValid = true
            }
            else
                Toast.makeText(applicationContext, "Input is Invalid. Please enter a valid Name", Toast.LENGTH_SHORT).show()

            if(contactNum.matches(phoneRegex) && contactNum.isNotEmpty()) {
                intentScr2.putExtra("contactData", contactNum)
                contactValid = true
            }
            else
                Toast.makeText(applicationContext, "Input is Invalid. Please enter a valid Phone Number", Toast.LENGTH_SHORT).show()

            if(simNet.isNotEmpty()) {
                intentScr2.putExtra("simData", simNet)
                simValid = true
            }
            else
                Toast.makeText(applicationContext, "Input is Invalid. Please enter a valid Sim Network", Toast.LENGTH_SHORT).show()

            if(addr.isNotEmpty()) {
                intentScr2.putExtra("addrData", addr)
                addrValid = true
            }
            else
                Toast.makeText(applicationContext, "Input is Invalid. Please enter a valid Address", Toast.LENGTH_SHORT).show()

            if (nameValid && contactValid && simValid && addrValid) {
                Toast.makeText(applicationContext, "Saving details...", Toast.LENGTH_SHORT).show()
                startActivity(intentScr2)
                this.finish()
            }
        }
    }
}