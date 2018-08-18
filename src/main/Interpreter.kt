package main

import main.actions.Action
import main.world.World

object Interpreter {
    var promptInput: String? = null
    var actions: ArrayList<Action> = arrayListOf()

    var placeActionMap: MutableMap<Int, Action> = mutableMapOf()

    fun prompt() {
        while (promptInput != "exit") {
            print("/ ")
            promptInput = readLine()
            if (promptInput != null) {
                perform(promptInput!!)
            }
        }
    }

    private fun perform(promptInput: String) {
        when (promptInput) {
            "whatis" ->
                presentActions()
            "help","?" ->
                println("""
                    |
                    |  H E L P
                    |
                    |    whatis     What's in the room
                    |    help       Get list of main.main.actions
                    |    reset      Reset again
                    |    exit       Exit game
                    |
                """.trimMargin())
            "reset" ->
                return World.reset()
            "exit" ->
                return World.endSession()
            else ->
                if (placeActionMap[promptInput.toInt()] is Action) {
                    placeActionMap[promptInput.toInt()]!!.perform()
                } else {
                    println("You can't do that.")
                }
        }
    }

    fun presentActions() {
        val itemCount: Int = World.currentPlace!!.placeInventory.size
        if (itemCount > 0) {
            var i = 0
            World.currentPlace!!.placeInventory.forEach {
                println("\n${it.name}:")
                it.actions.forEach {
                    println("[ $i ] ${it.affordanceMessage}")
                    placeActionMap[i] = it
                    i++
                }
            }
            println()
        }
    }

    fun playAgain() {
        while (promptInput != "y" || promptInput != "Y" || promptInput != "n" || promptInput != "N") {
            print("Play again? [ Y / N ]: ")
            promptInput = readLine()
            if (promptInput == "y" || promptInput == "Y") {
                World.reset()
            } else if (promptInput == "n" || promptInput == "N") {
                World.endSession()
            }
        }
    }

    fun passActions(currentActions: ArrayList<Action>) {
        actions.clear()
        actions.addAll(currentActions)
    }
}