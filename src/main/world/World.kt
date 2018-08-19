package main.world

import main.actions.Action
import main.actions.AffordanceType
import main.items.Item
import main.places.Place
import main.places.PlaceType
import main.Interpreter
import com.sun.tools.javac.util.FatalError
import main.items.ItemType
import main.player.HealthImpactType

object World {
    var places: ArrayList<Place> = arrayListOf()
    var startingPlace: Place? = null
    var currentPlace: Place? = null

    fun run() {
        if (startingPlace != null) {
            currentPlace = startingPlace
        } else {
            currentPlace = places.first()
        }
        if (currentPlace != null) {
            currentPlace!!.entry()
            Interpreter.prompt()
        } else {
            FatalError("Can not set place!")
        }

    }

    fun generateWorld() {

        val hallway = Place("Hallway", "You are in the hallway.", PlaceType.HALLWAY)
        val bedroom = Place("Bedroom", "You are in your bedroom.", PlaceType.ROOM)
        val emptyRoom = Place("Empty Room", "You are in a room.", PlaceType.ROOM)

        // Hallway items
        val bedroomDoor: Item = Item("Door", arrayListOf(
                Action("Open the door.", "Opened the door.", "", AffordanceType.PORTAL, HealthImpactType.NONE, bedroom)
        ), ItemType.STATIC)
        val emptyRoomDoor: Item = Item("Door", arrayListOf(
                Action("Open the door.", "Opened the door.", "", AffordanceType.PORTAL, HealthImpactType.NONE, emptyRoom)
        ), ItemType.STATIC)

        // Bedroom items
        val bed: Item = Item("Bed", arrayListOf(
                Action("Sleep in the bed.", "Sleeping in the bed.", "You are fast asleep.", AffordanceType.SLEEP, HealthImpactType.NONE),
                Action("Sit on the bed.", "Sitting on the bed.", "It's rather soft.", AffordanceType.SIT, HealthImpactType.NONE)
        ), ItemType.STATIC)
        val chair: Item = Item("Chair", arrayListOf(
                Action("Sit on the chair.", "Sitting on the chair.", "It's a comfy chair.", AffordanceType.SIT, HealthImpactType.NONE),
                Action("Pickup the chair.", "Picked up the chair.", "It's not that heavy.", AffordanceType.PICKUP, HealthImpactType.NONE)
        ), ItemType.PORTABLE)
        val cactus: Item = Item("Cactus", arrayListOf(
                Action("Touch the cactus.", "Touching the cactus.", "Ouch! You're bleeding!", AffordanceType.TOUCH, HealthImpactType.BLEEDING),
                Action("Pickup the cactus.", "Picked up the cactus.", "OUCH! The cactus thorns are piercing your skin.", AffordanceType.PICKUP, HealthImpactType.BLEEDING)
        ), ItemType.PORTABLE)
        val door1: Item = Item("Door", arrayListOf(
                Action("Open the door.", "Opened the door.", "", AffordanceType.PORTAL, HealthImpactType.NONE, hallway)
        ), ItemType.STATIC)

        // Empty Room items
        val door2: Item = Item("Door", arrayListOf(
                Action("Open the door.", "Opened the door.", "", AffordanceType.PORTAL, HealthImpactType.NONE, hallway)
        ), ItemType.STATIC)

        // Add items into places
        hallway.addItems(arrayListOf(
                bedroomDoor,
                emptyRoomDoor
        ))
        bedroom.addItems(arrayListOf(
                bed,
                chair,
                cactus,
                door1
        ))
        emptyRoom.addItems(arrayListOf(
                door2
        ))

        // Assemble world
        batchAddPlaces(
                arrayListOf(
                        hallway,
                        bedroom,
                        emptyRoom
                )
        )

        startingPlace = places.first()
    }

    private fun batchAddPlaces(placeArray: ArrayList<Place>) {
        placeArray.forEach {
            places.add(it)
        }
    }

    fun reset() {
        places.clear()
        startingPlace = null
        currentPlace = null
        println("\u001Bc")
        generateWorld()
        run()
    }

    fun endSession() { System.exit(0) }
}