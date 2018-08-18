package items

import actions.Action
import actions.AffordanceType

class Item(
        val nameInput: String,
        val affordanceInput: ArrayList<Action>,
        val typeInput: ItemType
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