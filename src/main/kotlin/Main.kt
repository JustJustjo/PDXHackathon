package org.example

import org.example.RequestGetter.getRequest
import org.example.javaFX.KApplication


fun main() {
    KApplication.main()
    println(getRequest("https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&HISP=2&for=state:*"))
}