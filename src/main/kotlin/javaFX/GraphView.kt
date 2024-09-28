package org.example.javaFX

import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.layout.VBox

object GraphView: VBox() {
    val xAxis = NumberAxis()
    val yAxis = NumberAxis()
    val lineChart = LineChart(xAxis, yAxis)

    val series = XYChart.Series<Number, Number>()

    init {
        xAxis.label = "Year"
        yAxis.label = "Population"

        xAxis.isAutoRanging = false
        xAxis.lowerBound = 2000.0
        xAxis.upperBound = 2050.0

        lineChart.data.add(series)
        children.add(lineChart)
    }

    fun addData(year: Int, population: Int) {
        series.data.add(XYChart.Data(year, population))
    }

    fun clearData() {
        series.data.clear()
    }

}