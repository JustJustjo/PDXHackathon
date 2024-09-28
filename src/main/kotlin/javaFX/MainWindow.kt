package org.example.javaFX

import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.layout.VBox

object MainWindow: VBox() {
    val stateChooser = ComboBox<String>()
//    val monthChooser = ComboBox<String>()
    val yearPicker = ComboBox<Int>()

    init {
        stateChooser.items.addAll(Constants.allStateList)
        stateChooser.selectionModel.selectFirst()

        yearPicker.items.addAll(2023..2050)
        yearPicker.selectionModel.selectFirst()

        GraphView.addData(2000, 1)
        GraphView.addData(2001, 2)
        GraphView.addData(2002, 3)
        GraphView.addData(2003, 4)
        GraphView.addData(2004, 5)
        GraphView.addData(2005, 6)
        GraphView.addData(2006, 7)
        GraphView.addData(2007, 8)
        GraphView.addData(2008, 9)

//        monthChooser.items.addAll(Constants.allMonths)
//        monthChooser.selectionModel.selectFirst()

//        yearPicker.setMaxSize(50.0, Double.MAX_VALUE)

        this.alignment = Pos.CENTER
        this.children.addAll(Label("State", stateChooser), Label("Year", yearPicker), GraphView)
    }
}

