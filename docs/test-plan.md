# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Testing Coin Placement

I need to make sure that coins are placed on the grid correctly

### Test Data To Use

I will run the game multiple times to see how the coins get placed

### Expected Test Result

I should see always see five coins called Coin 1, Coin 2, Coin 3, Coin 4 and, Gold, each coin should be in a random grid and not in the same grid as another coin.

---

## Testing Grid Display

I need to make sure that coins and grid are displayed so that the user can see what is going on

### Test Data To Use

I will run the code once to check that the grid looks as expected and how the coins are placed within the grid (not outside the boundary)

### Expected Test Result

The grids will have every coin fitting nicely inside and the corners of each grid will have the + line up with the sides |, I expect the coins to fit within the sides |   | 

---

## Moving the coin one space

I need to see whether the coins are able to move into another grid and not move into grids that other coins are already in.
If the coin is in the first grid it will be removed from the grid.

### Test Data To Use

I will test moving multiple coins around and seeing what happens when they are to move into another coin and move when on the first grid.
### Expected Test Result

I expect the coin to disappear from the grid it is currently in and move into another grid. If the coin is in the first grid I expect it to be removed from the game.

---


## Choosing how many spaces to move the coin

I need to make sure that the user will be able to choose how many spaces they move the coin without passing another coin while not going out of the grids.
The coins will only be able to move to the first grid where if they are then moved will be removed from the game.

### Test Data To Use

I will test moving a coins more than 20 grids (the number of grids),
move a coin within the number of grids while going past grid 1,
move multiple coins around testing that they won't be able to pass over another,
and move a coin a decimal and a negative amount of grids.
I will also test that the coin is removed and the user will not be asked how many spaces to move the coin, if it is in the first grid.


### Expected Test Result

I expect that when the user is asked how many spaces they can move the coin, if the user is to enter a number that will cause the coin to move off the grid they will be given the message "You cannot move past grid 1" and the coin will not move.
I expect that when the user is to make the coins pass over another they will be given the message "Cannot move another coin is in the way at grid X" and the coin will not move.
I expect that when the user is to enter a decimal or a negative number they will be asked to enter a valid number.
I expect that the user will not be asked to how many spaces to move the coin, and it will instead be removed if the chosen coin is in the first grid.

---

## Player names and taking turns

I need to make sure that for this game to be functional, the players can enter their names and when it is their turn it will be displayed on screen.
I also need to make sure that the game correctly knows which players turn it is so that if an invalid move is done that player will not skip their turn

### Test Data To Use
I will test once entering player names and that they are displayed when it is their turn, the players will not be able to leave their name blank.
I will test entering invalid data such as moving the coin out of the grid, having the coins on the same grid or pass over another, or not choosing a coin, to make sure that the players can not skip their turn and move onto the next.

### Expected Test Result

I expect the player names to be displayed when it is their turn, and that it will not be entered blank.
I expect that the game will correctly select which player is to move when invalid data is used on a players turn so that players cannot skip their turn.

---

## Winning the game

When the user is to remove the gold coin, the game will end and the player to remove the coin will be declared the winner.

### Test Data To Use

I will do two different tests, one where player 1 is to remove the gold coin, and one where the 2nd player is to remove the coin.
The user to remove the coin will then be declared the winner and the game will stop,

### Expected Test Result

I expect that when player 1 is to remove the coin, they will be declared the winner and the game will end.
I expect that when player 2 is to remove the coin, they will be declared the winner and the game will end.

---


## Example Test Name

Example test description. Example test description. Example test description. Example test description. Example test description. Example test description.

### Test Data To Use

Details of test data and reasons for selection. Details of test data and reasons for selection. Details of test data and reasons for selection.

### Expected Test Result

Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen.

---
