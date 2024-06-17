package com.example.smarthome

open class SmartDevice() {

    protected var isOn = false

    open fun getStatus() = isOn

    open fun switch() {
        isOn = !isOn
    }
}

class SmartLamp(val model: String, val bright: Int): SmartDevice() {

    override fun getStatus() = isOn

    override fun switch() {
        isOn = !isOn
    }
}

class SmartTv(val model: String): SmartDevice() {

    override fun getStatus() = isOn

    override fun switch() {
        isOn = !isOn
    }

    fun switchInput() {
        // меняет вход
    }
}