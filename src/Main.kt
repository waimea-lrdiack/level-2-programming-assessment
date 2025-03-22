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

    println("Placing existing monkeys into cages...")

    placeCoinInGrid(grids, 1, "Coin 1")
    placeCoinInGrid(grids, 8, "Coin 2")
    placeCoinInGrid(grids, 3, "Coin 3")
    placeCoinInGrid(grids, 5, "Coin 4")
    placeCoinInGrid(grids, 6, "Gold Coin")

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

fun placeCoinInGrid(gridList: MutableList<String>, gridNum: Int, coin: String) {
    // Check for invalid cage number
    if (gridNum !in 1..NUMGRIDS) return
    // Check for blank name
    if (coin.isBlank()) return
    // Ok to go ahead and place the coin
    println("+++ Putting $coin into grid $gridNum")
    gridList[gridNum - 1] = coin
}