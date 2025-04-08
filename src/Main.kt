
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
 * Set up and show the grid for Old Gold
 * Add coins into the game
 * Make the coins position random
 * Allow players to move the coins to the left
 * If a coin is in the first grid it can then be removed
 * Make sure the coins cannot be moved into a grid another coin is in.
 * Allow the user to move the coin as far as they want
 * Stop errors from happening such as coins overlapping, moving a decimal amount of spaces, moving negative spaces, moving the coins out of the grid.
 * To do: Make it so that users cannot skip their turn
 * To do: declare a winner if gold coin is removed
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

    val coins = listOf("Coin 1", "Coin 2", "Coin 3", "Coin 4", "Gold") // adds the coins to the game
    placeCoins(grids, coins) // coins are placed into the grids

    println()
    showGrids(grids)

    val player1 = getString("Player 1, what is your name? ") // gets users name
    val player2 = getString("Player 2, what is your name? ")

    val players = listOf(player1, player2)
    var currentPlayerNumber = 0  // Track the current player (0 = Player 1, 1 = Player 2)

    println("Welcome $player1 and $player2 to the OLD GOLD game") // tells players what to do
    println()
    println("Enter 1 to move Coin 1")
    println()
    println("Enter 2 to move Coin 2")
    println()
    println("Enter 3 to move Coin 3")
    println()
    println("Enter 4 to move Coin 4")
    println()
    println("Enter G to move the Gold Coin")
    println()
    println("Enter Q to quit the game")

    while (true) {
        showGrids(grids) // shows the grids so the players will see changes
        println()

        val currentPlayer = players[currentPlayerNumber]
        println("It's $currentPlayer's turn!") // Show whose turn it is

        val playerInput = getUserInput()

        if (playerInput == 'Q') break // Quit game
        val coinToMove = when (playerInput) {
            '1' -> "Coin 1"
            '2' -> "Coin 2"
            '3' -> "Coin 3"
            '4' -> "Coin 4"
            'G' -> "Gold"
            else -> continue
        }
        moveCoin(grids, coinToMove, currentPlayer)

        currentPlayerNumber = (currentPlayerNumber + 1) % 2 // change to the other player when turn is done (%2 makes it so that the current player will only be able to alternate between 0,1)
    }
}

fun setUpGrids(): MutableList<String> {
    val gridList = mutableListOf<String>()
    for (grids in 1..NUMGRIDS) gridList.add(EMPTY) // makes every grid in the list empty
    return gridList
}

fun showGrids(gridList: List<String>) {

    val gridWidth = 8  // sets the width of the grids (set to 11 due to Gold Coin taking up 9 spaces)

    val divider = "+${"-".repeat(gridWidth)}".repeat(gridList.size) + "+" // repeats the +----------+ pattern

    println(divider)
    for (grid in gridList) print("| ${grid.padEnd(gridWidth - 2)} ") // will print a line that looks like this |      | so that the coins fit in between and the line add up with the +
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
        println("What coin do you want to move?: ")
        val input = readln()
        // typed nothing? try again
        if (input.isBlank()) continue
        // grab the first letter
        val choice = input.uppercase().first()

        // check for a valid option
        if (validChoices.contains(choice)) return choice
    }
}

fun moveCoin(gridList: MutableList<String>, coinName: String, currentPlayer: String) {
    val coinIndex = gridList.indexOf(coinName) // Find the coin's position

    if (coinIndex == -1) { // since when a coin is removed its index becomes -1, this error message is played
        println("Error: $coinName is not found on the board!")
        return
    }

    if (coinIndex == 0) { // if the coin is in grid 1 ( 0 in the list), their position becomes empty
        gridList[coinIndex] = EMPTY
        println("$coinName has been removed!")
        return
    }

    if (gridList[coinIndex - 1] != EMPTY) {  // Check if the left grid is occupied and if so won't allow them to move the coin
        println("Cannot move $coinName, Grid $coinIndex is already occupied.")
        return
    }

    val movedSpaces = getSpacesToMove("$currentPlayer, how many spaces do you want to move $coinName?  ")

    val newPosition = coinIndex - movedSpaces // since the coin moves left taking away the coins original position by the moved spaces gives the new position.

    if (newPosition < 0) { // prevents coins from moving past grid 1
        println("You can't move past Grid 1!")
        return
    }

    for (i in newPosition until coinIndex) {
        if (gridList[i] != EMPTY) {
            println("Cannot move! Another coin is in the way at Grid ${i + 1}.")
            return
        }
    }


    gridList[coinIndex] = EMPTY // The coin will be removed from its original spot in the list so,it can be moved to a new one
    gridList[newPosition] = coinName  // Place the coin into the new position
    println("Moved $coinName to Grid $coinIndex")

}

fun getSpacesToMove(prompt: String): Int {
    var intValue: Int?

    while(true) {
        val userInput = getString(prompt)
        intValue = userInput.toIntOrNull()

        if (intValue != null) {
            if (intValue < 1) {
                println("Please enter a number more than zero")
                continue
            }
            else {
                break
            }
        }
    }

    return intValue!!
}