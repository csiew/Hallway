package items

import actions.Affordance
import actions.AffordanceType

class Item(
        val nameInput: String,
        val affordanceInput: ArrayList<Affordance>
) {
    var name: String = nameInput
    var affordances: ArrayList<Affordance> = arrayListOf()

    init {
        this.affordances.addAll(affordanceInput)
    }
}