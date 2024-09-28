package org.example

object StateData {
    var stateData = mutableMapOf<String, List<StateSubData>>()
}

data class StateSubData(val year: Int, val population: Int)

object YearData {
    var yearData = mutableMapOf<Int, List<YearSubData>>()
}

data class YearSubData(val state : String, val population: Int)