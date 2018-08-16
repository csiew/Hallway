package world

import actions.Affordance
import actions.AffordanceType
import items.Item
import places.Place
import places.PlaceType
import Interpreter
import com.sun.tools.javac.util.FatalError

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
        // Create items
        var bed: Item = Item("Bed", arrayListOf(
                Affordance(AffordanceType.SLEEP),
                Affordance(AffordanceType.SIT)
        ))
        var chair: Item = Item("Chair", arrayListOf(
                Affordance(AffordanceType.SIT),
                Affordance(AffordanceType.PICKUP)
        ))
        // Put items into bedroom
        places.add(Place("Bedroom", PlaceType.ROOM, arrayListOf(
                bed,
                chair
        )))

        startingPlace = places.first()
    }
}