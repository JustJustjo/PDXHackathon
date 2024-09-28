package org.example.javaFX

import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import org.example.YearData

object MainWindow: VBox() {
    val stateChooser = ComboBox<String>()
//    val monthChooser = ComboBox<String>()
    val yearPicker = ComboBox<Int>()

    init {
        stateChooser.items.addAll(Constants.allStateList)
        stateChooser.selectionModel.selectFirst()
        stateChooser.setOnAction {
            updateGraph()
        }

        yearPicker.items.addAll(2005..2023)
        yearPicker.selectionModel.selectFirst()
        yearPicker.setOnAction {
            updateGraph()
        }

//        monthChooser.items.addAll(Constants.allMonths)
//        monthChooser.selectionModel.selectFirst()

//        yearPicker.setMaxSize(50.0, Double.MAX_VALUE)

        this.alignment = Pos.CENTER
        this.children.addAll(Label("State", stateChooser), Label("Year", yearPicker), GraphView)
    }

    fun updateGraph() {
        GraphView.clearData()
        val state = stateChooser.selectionModel.selectedItem
        val year = yearPicker.value
        println("updating graph from $year $state")

        println(YearData.yearData)

        var added = 0
        for (i in 2000..2023) {
            if (i != 2019) {
                YearData.yearData[i]?.forEach {
                    if (it.state == state) {
                        var population = it.population

                        if (i < 2020) {
//                            population += added
                        }
                        println("year: $i $population $added")


                        if (it.state == state) {
                            GraphView.addData(i, population)
                        }
                        added += it.population
                    }
                }
            }

        }
    }
}

