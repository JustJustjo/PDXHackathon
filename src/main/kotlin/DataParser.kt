package org.example

import org.example.RequestGetter.getRequest

class DataParser {
    fun DataParser() {
        // Population, Housing over a year -> Housing under a year
        val url1 = "https://api.census.gov/data/2023/acs/acs1/profile?get=NAME,DP02_0124E,DP02_0079E&for=county:*&in=state:*"

        val data1 = getRequest(url1)
        if (data1 != null) {
            for (i in data1.indices) {
                val countyData = data1[i]
            }
        }
    }
}