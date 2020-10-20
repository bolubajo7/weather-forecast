package com.summercamp.weather_forecast.tmp

class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40){
    init {
        println("aquarium initializing")
    } init {
        println("Volume: ${width * length * height /1000} 1")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1

        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    // Dimensions in cm
    var length: Int = length
    var width: Int = width
    var height: Int = height


    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
}

