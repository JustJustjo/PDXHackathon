package org.example

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.time.Year

object RequestGetter {

    val startYear = 2005

    fun calculate() {
        val result = mutableMapOf<Int, List<YearSubData>>()
        for (i in startYear..2023) {
            val allStates: MutableList<YearSubData> = mutableListOf()

            if (i == 2020) {
                continue
            }
            val code = if (i < 2006 ) "DP01_0001E" else if (i < 2008) "DP02_0085E" else if (i < 2020) "DP02_0086E" else "DP02_0088E"
            val stateData = getRequest("https://api.census.gov/data/$i/acs/acs1/profile?get=NAME,${code}&for=state:*")

            println(stateData)
            stateData.forEach {
                allStates.add(YearSubData(it.first, it.second))
            }

            result[i] = allStates
        }

        YearData.yearData = result
    }

    // Takes a URL (string) and returns a nested list containing the data at the given URL
    fun getRequest(urlString: String): List<Triple<String, Int, Int>> {
        val url = URL(urlString)
        val connection = url.openConnection()

        connection.doOutput = true

        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuilder()
        var line: String? = reader.readLine()
        //
        line = reader.readLine()
        response.append("[")
        while (line != null) {
            response.append(line);
            response.append('\n');
            line = reader   .readLine()
        }
//        println(response.toString())

        val gson = Gson()

        val stateResultList = gson.fromJson(response.toString(), List::class.java)
        val finalResultList: ArrayList<Triple<String, Int, Int>> = arrayListOf()
        for (stateResult in stateResultList) {
//            println(stateResult)

            val resultString = stateResult.toString()

            val rejectList = listOf("District of Columbia", "New Hampshire", "New Jersey", "New Mexico", "New Jersey", "New Mexico", "New York", "North Carolina", "North Carolina", "North Dakota", "Rhode Island", "Puerto Rico", "South Carolina", "South Dakota", "West Virginia")

            var valid = true

            rejectList.forEach {
                if (resultString.contains(it)) {
                    valid = false
                }
            }

            println(stateResult)
            if (valid) {
                val result = gson.fromJson(stateResult.toString(), List::class.java)
                println(result)
                finalResultList.add(
                    Triple(
                        result[0] as String,
                        (result[1] as Double).toInt(),
                        0))

            }


        }

        return finalResultList
    }

}