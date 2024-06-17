package com.example.smarthome

class SmartHome(private val devices: Array<SmartDevice>) {

    fun count(): Int {
        return devices.size
    }
}