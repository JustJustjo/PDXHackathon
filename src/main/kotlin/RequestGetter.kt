package org.example

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

object RequestGetter {
    // Takes a url (string) and returns a string containing the data at the given URL
    fun getRequest(urlString: String): String {
        val url = URL(urlString)
        val connection = url.openConnection()

        connection.doOutput = true

        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            response.append(line);
            response.append('\n');
//            println(line)
            line = reader.readLine()
        }
        return response.toString()
    }

}