package com.example.homework4

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val employee = Employee()
    private val awardsResources = mapOf(
        "best1" to R.drawable.best2, "best2" to R.drawable.best2,
        "best3" to R.drawable.best3, "best4" to R.drawable.best4, "best5" to R.drawable.best5,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.avatar).setImageResource(employee.photoSrc)
        (employee.surname + " " + employee.name + " " + employee.patronymic).also { findViewById<TextView>(R.id.fio).text = it }
        findViewById<TextView>(R.id.position).text = employee.position
        findViewById<TextView>(R.id.department).text = employee.department
        findViewById<TextView>(R.id.phone).text = employee.phone
        findViewById<TextView>(R.id.email).text = employee.email
        findViewById<TextView>(R.id.location).text = employee.location

        employee.awards.forEach {
            val imageView = ImageView(applicationContext)
            awardsResources[it]?.let { it1 -> imageView.setImageResource(it1) }
            findViewById<LinearLayout>(R.id.awards).addView(imageView)
        }

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        val vkButton = findViewById<Button>(R.id.vkButton) as ImageButton
        vkButton.setOnClickListener { Log.i("ClickListener", "VK button is clicked") }
        val telegramButton = findViewById<Button>(R.id.telegramButton) as ImageButton
        telegramButton.setOnClickListener {
            Log.i("ClickListener", "Telegram button is clicked")
        }
        val whatsappButton = findViewById<Button>(R.id.whatsappButton) as ImageButton
        whatsappButton.setOnClickListener {
            Log.i("ClickListener", "Whatsapp button is clicked")
        }
        val callButton = findViewById<Button>(R.id.callButton) as ImageButton
        callButton.setOnClickListener {
            Log.i("ClickListener", "Call button is clicked")
        }
        val messageButton = findViewById<Button>(R.id.messageButton) as ImageButton
        messageButton.setOnClickListener {
            Log.i("ClickListener", "Message button is clicked")
        }
    }
}