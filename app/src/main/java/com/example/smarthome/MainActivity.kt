package com.example.smarthome

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lamp1 = SmartLamp("L1000", 2500)
        val lamp2 = SmartLamp("E500", 4000)
        val tv1 = SmartTv("LG3000")

        val smartHome = SmartHome(devices = arrayOf(lamp1, lamp2, tv1))

        setupLamps(lamp1, lamp2)
        setupTv(tv1)

        val mainTitle = findViewById<TextView>(R.id.mainTitle)
        val countDevices = smartHome.count()
        mainTitle.text = "${mainTitle.text} _ ${countDevices}"
    }

    private fun setupTv(tv: SmartTv) {
        val tvIcon = findViewById<ImageView>(R.id.smartTv1)
        tvIcon.setOnClickListener {
            tv.switch()
            if (tv.getStatus()) {
                tvIcon.setColorFilter(baseContext.getColor(R.color.on_lamp_color))
            } else {
                tvIcon.setColorFilter(baseContext.getColor(R.color.off_lamp_color))
            }
        }
    }

    private fun setupLamps(lamp1: SmartLamp, lamp2: SmartLamp) {
        val lamp1Icon = findViewById<ImageView>(R.id.smartLamp1)
        val lamp2Icon = findViewById<ImageView>(R.id.smartLamp2)

        lamp1Icon.setOnClickListener {
            lamp1.switch()
            if (lamp1.getStatus()) {
                lamp1Icon.setColorFilter(baseContext.getColor(R.color.on_lamp_color))
            } else {
                lamp1Icon.setColorFilter(baseContext.getColor(R.color.off_lamp_color))
            }
        }

        lamp2Icon.setOnClickListener {
            lamp2.switch()
            if (lamp2.getStatus()) {
                lamp2Icon.setColorFilter(baseContext.getColor(R.color.on_lamp_color))
            } else {
                lamp2Icon.setColorFilter(baseContext.getColor(R.color.off_lamp_color))
            }
        }
    }
}