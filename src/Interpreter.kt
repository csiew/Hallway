import actions.Affordance
import world.World

object Interpreter {
    var promptInput: String? = null
    var actions: ArrayList<Affordance> = arrayListOf()

    fun prompt() {
        while (promptInput != "exit") {
            print("/ ")
            promptInput = readLine()
            if (promptInput != null) {
                perform(promptInput!!)
            }
        }
    }

    private fun perform(promptInput: String) {
        when (promptInput) {
            "whatis" ->
                presentItems()
            "help","?" ->
                println("""
                    |
                    |  H E L P
                    |
                    |    help       Get list of actions
                    |    exit       Exit game
                    |
                """.trimMargin())
            "exit" ->
                System.exit(0)
            else ->
                println("You can't do that.")
        }
    }

    private fun presentItems() {
        val itemCount: Int = World.currentPlace!!.placeInventory.size
        if (itemCount > 0) {
            println("There are $itemCount item(s) in the ${World.currentPlace!!.name}.")
            World.currentPlace!!.placeInventory.forEach {
                print(" ${it.name} \t\t ")
                it.affordances.forEach {
                    print("[${it.type.name}] ")
                }
                println()
            }
        }
    }

    private fun tryDo(tryInput: String) {

    }

    fun passActions(currentActions: ArrayList<Affordance>) {
        actions.clear()
        actions.addAll(currentActions)
    }
}