package org.example

import org.example.RequestGetter.getRequest
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


fun main() {
    println(getRequest("https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&HISP=2&for=state:*"))
}