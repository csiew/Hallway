package items

import actions.Action
import actions.AffordanceType

class Item(
        val nameInput: String,
        val affordanceInput: List<Action>
) {
    var name: String = nameInput
    var actions: List<Action> = arrayListOf()

    init {
        this.actions.addAll(affordanceInput)
    }
}