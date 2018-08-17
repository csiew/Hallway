package actions

import com.sun.tools.javac.util.FatalError

class Action (
        val typeInput: AffordanceType
) {
    var type: AffordanceType = typeInput

    fun usageMessage(name: String) {
        when (type) {
            AffordanceType.PICKUP ->
                println("Picking up $name")
            AffordanceType.DROP ->
                println("Dropping $name")
            AffordanceType.ATTACK ->
                println("Using $name to attack")
            AffordanceType.EAT ->
                println("Eating the $name")
            AffordanceType.SMELL ->
                println("Smelling the $name")
            AffordanceType.READ ->
                println("Reading $name")
            AffordanceType.SLEEP ->
                println("Sleeping in $name")
            AffordanceType.SIT ->
                println("Sitting on the $name")
        }
    }
}