package org.example.javaFX

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.layout.VBox

object MainWindow: VBox() {

    val stateChooser = ComboBox<String>()

    init {
        stateChooser.items.addAll(Constants.allStateList)


        this.alignment = Pos.CENTER
        this.children.addAll(stateChooser, Button())
    }
}