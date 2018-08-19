package main.actions

import main.Interpreter
import main.places.Place
import main.player.HealthImpactType
import main.player.Player
import main.player.PlayerEventType
import main.world.World

class Action (
        affordanceMessageInput: String,
        doingMessageInput: String,
        doingResultMessageInput: String,
        typeInput: AffordanceType,
        healthImpactTypeInput: HealthImpactType,
        destinationInput: Place? = null
) {
    var affordanceMessage: String = affordanceMessageInput
    var doingMessage: String = doingMessageInput
    val doingResultMessage: String = doingResultMessageInput
    var type: AffordanceType = typeInput
    var healthImpactType: HealthImpactType = healthImpactTypeInput
    var destination: Place? = null

    init {
        if (destinationInput != null) {
            destination = destinationInput
        }
    }

    fun perform() {
        println(doingMessage)
        if (doingResultMessage.isNotEmpty()) {
            println(doingResultMessage)
        }
        if (type == AffordanceType.PORTAL && destination != null) {
            World.currentPlace = destination
            destination!!.entry()
        }
        if (Player.takeDamage(healthImpactType) == PlayerEventType.DEATH) {
            Interpreter.playAgain()
        }
    }
}