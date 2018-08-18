package main

import main.world.World

fun main(args: Array<String>) {
    println("Hallway: A Game")

    World.generateWorld()
    World.run()
}