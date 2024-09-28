package org.example.javaFX

import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import org.example.Data

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

        println(Data.stateData)

        for (i in 2000..2023) {
            Data.stateData[i]?.forEach {
                if (it.value == state) {
                    GraphView.addData(i, it.population)
                }
            }
        }
    }
}

