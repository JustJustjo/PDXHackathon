package org.example

import org.example.RequestGetter.calculate
import org.example.RequestGetter.getRequest
import org.example.RequestGetter.stateData
import org.example.javaFX.KApplication


fun main() {
    calculate()
    println(stateData)
    KApplication.main()
}