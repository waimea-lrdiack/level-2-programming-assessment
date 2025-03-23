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

    showGrids(grids)
    println()

    println("Placing coins randomly")

    val coins = listOf("Coin 1", "Coin 2", "Coin 3", "Coin 4", "Gold Coin")
    placeCoins(grids, coins)

    println()
    showGrids(grids)
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