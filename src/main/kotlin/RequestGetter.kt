package org.example

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.time.Year


object RequestGetter {

    val startYear = 2005

    fun calculate() {
        val result = mutableMapOf<Int, List<State>>()
        for (i in startYear..2023) {
            val allStates: MutableList<State> = mutableListOf()

            if (i == 2020) {
                continue
            }
            val stateData = getRequest("https://api.census.gov/data/$i/acs/acs1/profile?get=NAME,DP02_0124E&for=state:*")

            stateData.forEach {
                allStates.add(State(it.first, it.second))
            }

            result[i] = allStates
        }

        Data.stateData = result
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
            val result = gson.fromJson(stateResult.toString(), List::class.java)
            finalResultList.add(Triple(result[0] as String, result[1] as Int, result[2] as Int))
        }

        return finalResultList
    }

}