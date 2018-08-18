package main.places

import main.Interpreter
import main.actions.Action
import main.items.Item

class Place(
        val nameInput: String,
        val placeTypeInput: PlaceType,
        val placeInventoryInput: ArrayList<Item>
) {
    var name: String = nameInput
    var placeType: PlaceType = placeTypeInput
    var placeInventory: ArrayList<Item> = arrayListOf()
    var actions: ArrayList<Action> = arrayListOf()

    val welcomeMessage: String = "You are in your bedroom."

    init {
        this.placeInventory.addAll(placeInventoryInput)
    }

    fun entry() {
        Interpreter.presentActions()
        println(welcomeMessage)
    }

    fun exit() {
        Interpreter.placeActionMap.clear()
    }

    fun actions() {

    }
}