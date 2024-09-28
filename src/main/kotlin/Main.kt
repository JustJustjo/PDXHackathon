package org.example

import org.example.RequestGetter.calculate
import org.example.RequestGetter.getRequest
import org.example.javaFX.KApplication


fun main() {
    calculate()
    KApplication.main()
    val url = "https://api.census.gov/data/timeseries/eits/ressales"
    println(getRequest(url))

    val x = doubleArrayOf(0.1, 0.9, 1.6, 3.0)
    val y = doubleArrayOf(1.0, 1.5, 1.7, 1.4)
    val funcClass : FunctionClass = FunctionClass()
    funcClass.initialize(x, y)
    println(funcClass.evaluate(3.0))
}