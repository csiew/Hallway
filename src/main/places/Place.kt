package main.places

import main.Interpreter
import main.actions.Action
import main.items.Item

class Place(
        nameInput: String,
        welcomeMessageInput: String,
        placeTypeInput: PlaceType,
        placeInventoryInput: ArrayList<Item>? = arrayListOf()
) {
    var name: String = nameInput
    var placeType: PlaceType = placeTypeInput
    var placeInventory: ArrayList<Item> = placeInventoryInput!!
    var actions: ArrayList<Action> = arrayListOf()

    val welcomeMessage: String = welcomeMessageInput

    init {
        this.placeInventory.addAll(placeInventoryInput!!)
    }

    fun entry() {
        Interpreter.presentActions()
        println(welcomeMessage)
    }

    fun addItems(inventory: ArrayList<Item>) {
        if (inventory.isNotEmpty()) {
            this.placeInventory.addAll(inventory)
        }
    }

    fun exit() {
        Interpreter.placeActionMap.clear()
    }

    fun actions() {

    }
}