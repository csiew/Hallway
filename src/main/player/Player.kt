package main.player

import main.items.Item

object Player {
    var inventory: ArrayList<Item> = arrayListOf()
    var healthPoints: Int = 100
    var healthStatus: HealthStateType = HealthStateType.FINE

    fun takeDamage(impactType: HealthImpactType): PlayerEventType {
        when (impactType) {
            HealthImpactType.POISON -> {
                healthPoints -= 60
                healthStatus = HealthStateType.WEAK
            }
            HealthImpactType.FARFALL -> {
                healthPoints -= 50
                healthStatus = HealthStateType.INJURED
            }
            HealthImpactType.SHORTFALL -> {
                healthPoints -= 5
                healthStatus = HealthStateType.FINE
            }
            HealthImpactType.HEADKNOCK -> {
                healthPoints -= 10
                healthStatus = HealthStateType.CONFUSED
            }
            HealthImpactType.KNOCKEDOUT -> {
                healthPoints -= 20
                healthStatus = HealthStateType.UNCONSCIOUS
            }
            HealthImpactType.BLEEDING -> {
                healthPoints -= 5
                healthStatus = HealthStateType.WEAK
            }
            HealthImpactType.INSTANTDEATH -> {
                healthPoints = 0
                healthStatus = HealthStateType.DEAD
            }
            HealthImpactType.NONE -> {
                healthStatus = HealthStateType.FINE
            }
            else ->
                println("ERROR: Unknown health impact type received!")
        }

        println("Health Points: $healthPoints")

        if (healthPoints <= 0) {
            println("You died!")
            healthStatus = HealthStateType.DEAD
            return PlayerEventType.DEATH
        }

        return PlayerEventType.NONE
    }
}