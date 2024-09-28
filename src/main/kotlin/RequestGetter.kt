package org.example

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

object RequestGetter {
    val stateData: ArrayList<Any> = arrayListOf()

    val startYear = 2005

    fun calculate() {
        for (i in startYear..2023) {
            if (i == 2020) {
                continue
            }
            getRequest("https://api.census.gov/data/$i/acs/acs1/profile?get=NAME,DP02_0124E&for=state:*")?.let {
                stateData.add(
                    it
                )
            }
        }
    }

    // Takes a URL (string) and returns a nested list containing the data at the given URL
    fun getRequest(urlString: String): List<*>? {
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
        println(response.toString())

        val gson = Gson()

        return gson.fromJson(response.toString(), List::class.java)
    }

}