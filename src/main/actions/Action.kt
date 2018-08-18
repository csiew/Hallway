package main.actions

import main.Interpreter
import main.player.HealthImpactType
import main.player.Player
import main.player.PlayerEventType

class Action (
        val affordanceMessageInput: String,
        val doingMessageInput: String,
        val doingResultMessageInput: String,
        val typeInput: AffordanceType,
        val healthImpactTypeInput: HealthImpactType
) {
    var affordanceMessage: String = affordanceMessageInput
    var doingMessage: String = doingMessageInput
    val doingResultMessage: String = doingResultMessageInput
    var type: AffordanceType = typeInput
    var healthImpactType: HealthImpactType = healthImpactTypeInput

    fun perform() {
        println("$doingMessage\n$doingResultMessage")
        if (Player.takeDamage(healthImpactType) == PlayerEventType.DEATH) {
            Interpreter.playAgain()
        }
    }
}