
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
 * declare a winner if gold coin is removed
 * make sure the users turn isn't skipped when they enter invalid data or break boundary
 * =====================================================================
 */

/**
 * Constant vales used to define the key values used throughout the device
 * NUMGRIDS is the number of grids in the game
 * EMPTY is for every empty grid in the game
 * containGold is for making sure the gold coin is still in the grid, if it isn't the game will end
 */

const val NUMGRIDS = 15
const val EMPTY = ""
var containGold = true

fun main() {
    println("THE OLD GOLD GAME".bgYellow())
    println("=======================================================================================")
    println()
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

    println("Welcome to the Old Gold Game!!!".bgYellow())
    println()
    println("=======================================================================================")
    println()
    println("To win this game you will need to be the player to remove the gold coin from the grid")
    println("However, for this to be done the gold coin will need to be moved into the first grid")
    println("coins cannot pass over one another or move into a grid that another coin is already in")
    println()

    val player1 = getString("Player 1, what is your name? ") // gets users name
    val player2 = getString("Player 2, what is your name? ")
    println()

    val players = listOf(player1.blue(), player2.red())
    var currentPlayerNumber = 0  // Track the current player (0 = Player 1, 1 = Player 2)

    println("Good luck ${player1.blue()} and ${player2.red()}")
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
    println()

    var currentPlayer: String

    while (true) {
        currentPlayer = players[currentPlayerNumber]

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

        val moveSuccessful = moveCoin(grids, coinToMove, currentPlayer)

        if (moveSuccessful) {
            checkGold(grids) // Check if the Gold coin is still on the board

            if (!containGold) { // when containGold is false break
                break
            }
            currentPlayerNumber = (currentPlayerNumber + 1) % 2
            // Switch to the other player when the turn is done (%2 makes it so that the current player will only be able to alternate between 0,1)
            println()
            showGrids(grids) // shows the grids so the players will see changes
            println()
        }

        else {
            println("Invalid move, try again.")
            println()
        }
    }
    println()
    println("The winner is...".yellow())
    println()
    println("$currentPlayer!!!")
    println()
    println("Thank you for playing ${player1.blue()} and ${player2.red()}")
}

fun setUpGrids(): MutableList<String> {
    val gridList = mutableListOf<String>() // the list is created
    for (grids in 1..NUMGRIDS) gridList.add(EMPTY) // adds empty grids
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
        print(prompt) // prints the question
        userInput = readln() // gets data from the user
        if (userInput.isNotBlank()) break // the user will have to enter something for the loop to break
    }

    return userInput
}

fun getUserInput(): Char {
    val validChoices = "1234GQ"

    while (true) {
        println("What coin do you want to move?: ")
        val input = readln() // gets data from the user

        if (input.isBlank()) continue // makes sure the user types something

        val choice = input.uppercase().first() // takes the first character the user inputted

        if (validChoices.contains(choice)) return choice // if the user had entered one of the valid choices the loop will end
    }
}

fun moveCoin(gridList: MutableList<String>, coinName: String, currentPlayer: String): Boolean {
    // returns true when the user has made a valid move so that it can become the other players turn
    // returns false when the user has made an invalid move so that the users turn is not skipped

    val coinIndex = gridList.indexOf(coinName) // Find the coin's position


    if (coinIndex == -1) { // when a coin is removed its index becomes -1, this error message is played
        println("Error: $coinName is not found on the board!")
        return false
    }

    if (coinIndex == 0) { // if the coin is in grid 1 ( 0 in the list), their position becomes empty
        gridList[coinIndex] = EMPTY
        println("$coinName has been removed!")

        return true
    }

    if (gridList[coinIndex - 1] != EMPTY) {  // Check if the left grid is occupied and if so won't allow them to move the coin
        println("Cannot move $coinName, Grid $coinIndex is already occupied.")
        return false
    }

    val movedSpaces = getSpacesToMove("$currentPlayer, how many spaces do you want to move $coinName?  ")

    val newPosition = coinIndex - movedSpaces // since the coin moves left taking away the coins original position by the moved spaces gives the new position.

    if (newPosition < 0) { // prevents coins from moving past grid 1
        println("You can't move past Grid 1!")
        return false
    }

    for (i in newPosition until coinIndex) {
        if (gridList[i] != EMPTY) {
            println("Cannot move! Another coin is in the way at Grid ${i + 1}.")
            return false
        }
    }

    // this happens when there are no issues
    gridList[coinIndex] = EMPTY // The coin will be removed from its original spot in the list so,it can be moved to a new one
    gridList[newPosition] = coinName  // Place the coin into the new position
    println("Moved $coinName to Grid ${newPosition + 1}")

   return true
}

fun getSpacesToMove(prompt: String): Int {
    var intValue: Int?

    while(true) {
        val userInput = getString(prompt)
        intValue = userInput.toIntOrNull() // will get a number from the user

        if (intValue != null) {
            if (intValue < 1) { // makes sure the user is to move the coin at least 1 grid
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

fun checkGold(gridList: MutableList<String>) {
    if (gridList.contains("Gold")) { // checks whether the gold coin is still on the board
        containGold = true
    }

    if (!gridList.contains("Gold")) { // containGold becomes false when the gold coin is removed which causes the game to end
        containGold = false
    }
}