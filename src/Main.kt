
/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   OLD GOLD
 * Project Author: Liam Diack
 * GitHub Repo:    https://github.com/waimea-lrdiack/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 *
 * Set up the grid for Old Gold
 * =====================================================================
 */

/**
 * Constant vales used to define the key values used throughout the device
 */

const val NUMGRIDS = 20
const val EMPTY = ""

fun main() {
    println("Setting up grids")

    val grids = setUpGrids()
    println()

    showGrids(grids) // using the showGrids function the grids are shown the user
    println()

    println("Placing coins randomly")

    val coins = listOf("Coin 1", "Coin 2", "Coin 3", "Coin 4", "Gold Coin") // adds the coins to the game
    placeCoins(grids, coins) // coins are placed into the grids

    println()
    showGrids(grids)

    val player1 = getString("Player 1, what is your name? ") // gets users name
    val player2 = getString("Player 2, what is your name? ")

    println("Welcome $player1 and $player2 to the OLD GOLD game") // tells players what to do
    println("Enter 1 to move Coin 1")
    println("Enter 2 to move Coin 2")
    println("Enter 3 to move Coin 3")
    println("Enter 4 to move Coin 4")
    println("Enter G to move the Gold Coin")
    println("Enter Q to quit the game")

    while (true) {
        showGrids(grids)

        val playerInput = getUserInput()

        when (playerInput) {
            'Q' -> break
            '1' -> moveCoin(grids, "Coin 1")
            '2' -> moveCoin(grids, "Coin 2")
            '3' -> moveCoin(grids, "Coin 3")
            '4' -> moveCoin(grids, "Coin 4")
            'G' -> moveCoin(grids, "Gold Coin")
        }
    }
}

fun setUpGrids(): MutableList<String> {
    val gridList = mutableListOf<String>()
    for (grids in 1..NUMGRIDS) gridList.add(EMPTY)
    return gridList
}

fun showGrids(gridList: List<String>) {

    val gridWidth = 11  // sets the width of the grids (set to 11 due to Gold Coin taking up 9 spaces)

    val divider = "+${"-".repeat(gridWidth)}".repeat(gridList.size) + "+" // repeats the +----------+ pattern

    println(divider)
    for (grid in gridList) print("| ${grid.padEnd(gridWidth - 2)} ")
    println("|")
    println(divider)
}

fun placeCoins(gridList: MutableList<String>, coins: List<String>) {

    val randomize = (gridList.indices).shuffled()  // shuffles the list, so that the coin is placed into a random grid

    for ((index, coin) in coins.withIndex()) {
        val place = randomize[index] // place will make another value be put into the random position

        // due to lists starting at 0, the grid the coin is placed in will be one more than its index, gridNum is used to show the user which grid the coin is in.
        val gridNum = place +1

        println("+++ Placing $coin in grid $gridNum")
        gridList[place] = coin // the coin is placed into the grid
    }
}

fun getString(prompt: String): String {
    var userInput: String

    while(true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }

    return userInput
}

fun getUserInput(): Char {
    val validChoices = "1234GQ"

    while (true) {
        println("What do you want to do?: ")
        val input = readln()
        // typed nothing? try again
        if (input.isBlank()) continue
        // grab the first letter
        val choice = input.uppercase().first()

        // check for a valid option
        if (validChoices.contains(choice)) return choice
    }
}

fun moveCoin(gridList: MutableList<String>, coinName: String) {
    val coinIndex = gridList.indexOf(coinName) // Find the coin's position

    if (coinIndex == -1) {
        println("Error: $coinName is not found on the board!")
        return
    }

    if (coinIndex == 0) {
        gridList[coinIndex] = EMPTY
        println("$coinName has been removed!")
        return
    }

    if (gridList[coinIndex - 1] != EMPTY) {  // Check if the left grid is occupied and if so won't allow them to move the coin
        println("Cannot move $coinName left! Grid $coinIndex is already occupied.")
        return
    }

    else {
        gridList[coinIndex] = EMPTY // The coin will be removed from its original spot in the list so it can be moved to a new one
        gridList[coinIndex - 1] = coinName  // Place it one grid to the left
        println("Moved $coinName to Grid $coinIndex")
    }
}