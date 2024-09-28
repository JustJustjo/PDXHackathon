package org.example

object Data {
    var stateData = mutableMapOf<Int, List<State>>()
}

data class State(val value: String, val population: Int)