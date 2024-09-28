package org.example.javaFX

import javafx.application.Application
import javafx.geometry.Rectangle2D
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Screen
import javafx.stage.Stage

class KApplication : Application() {
    companion object {
        lateinit var stage: Stage

        @JvmStatic
        fun main() {
            println("Launching NodeDeck...")
            launch(KApplication::class.java)
        }
    }

    override fun start(stage: Stage) {

        val screen = Screen.getPrimary()

        Companion.stage = stage

        val bounds = Rectangle2D(screen.visualBounds.minX, screen.visualBounds.minY, screen.visualBounds.width, screen.visualBounds.height)
        stage.scene = Scene(VBox(), bounds.width, bounds.height)
        stage.sizeToScene()
        stage.show()
    }

    override fun stop() {
        println("Bye")
    }
}