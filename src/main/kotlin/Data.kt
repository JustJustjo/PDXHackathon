package org.example

object Data {
    val stateData = mutableMapOf<String, List<Population>>()
}

data class Population(val value: Int, val year: Int)