package main.items

import main.actions.Action

open class Item(
        nameInput: String,
        affordanceInput: ArrayList<Action>,
        typeInput: ItemType
) {
    var name: String = nameInput
    var actions: ArrayList<Action> = arrayListOf()
    var type: ItemType = typeInput
    private var entryTriggerAction: Action? = null

    init {
        this.actions.addAll(affordanceInput)
    }

    fun addEntryTriggerAction(action: Action) {
        entryTriggerAction = action
    }

    fun entryTrigger() {
        if (entryTriggerAction != null) {
            entryTriggerAction!!.perform()
        }
    }
}