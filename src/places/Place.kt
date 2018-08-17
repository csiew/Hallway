package places

import items.Item

class Place(
        val nameInput: String,
        val placeTypeInput: PlaceType,
        val placeInventoryInput: ArrayList<Item>
) {
    var name: String = nameInput
    var placeType: PlaceType = placeTypeInput
    var placeInventory: List<Item> = arrayListOf()
    var actions: List<Action> = arrayListOf()

    val welcomeMessage: String = "You are in your bedroom."

    init {
        this.placeInventory.addAll(placeInventoryInput)
    }

    fun entry() {
        println(welcomeMessage)
    }

    fun actions() {

    }
}