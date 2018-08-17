package world

import actions.Action
import actions.AffordanceType
import items.Item
import places.Place
import places.PlaceType
import Interpreter
import com.sun.tools.javac.util.FatalError

object World {
    var places: List<Place> = arrayListOf()
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
        // Create items
        var bed: Item = Item("Bed", arrayListOf(
                Action(AffordanceType.SLEEP),
                Action(AffordanceType.SIT)
        ))
        var chair: Item = Item("Chair", arrayListOf(
                Action(AffordanceType.SIT),
                Action(AffordanceType.PICKUP)
        ))
        // Put items into bedroom
        places.add(Place("Bedroom", PlaceType.ROOM, arrayListOf(
                bed,
                chair
        )))

        startingPlace = places.first()
    }
}