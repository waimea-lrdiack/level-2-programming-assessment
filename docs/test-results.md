# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Testing Coin Placement

I need to make sure that coins are placed on the grid correctly

### Test Data To Use

I will run the game multiple times to see how the coins get placed

### Expected Test Result

I should see always see five coins called Coin 1, Coin 2, Coin 3, Coin 4 and, Gold, each coin should be in a random grid and not in the same grid as another coin

![200DTD_CoinPlacementTest.png](images/200DTD_CoinPlacementTest.png)

---

![200DTD_CoinPlacementTest2.png](images/200DTD_CoinPlacementTest2.png)

In my first test each coin was placed into a grid like I expected, I then ran the code again to check whether their placement was random or not.
As seen in the second image the coins were placed into different grids as the previous test.
I then ran the code again to make sure that their placement was definitely random and each time most of the coins were in different grids from the previous and not in the same grids as another coin.

---

## Testing Grid Display

I need to make sure that coins and grid are displayed so that the user can see the game board and the changes that

### Test Data To Use

I will run the game multiple times to see how the coins get placed

### Expected Test Result

The grids will have every coin fitting nicely inside and the corners of each grid will have the + line up with the sides |, I expect the coins to fit within the sides |   |

![200DTD_GridDisplayTest.png](images/200DTD_GridDisplayTest.png)

When I was to run the code the grid appeared in the +--------+ | | way that I had expected that it would line up and when the coins were placed inside the grids were not moved in any way and the coins fitted nicely inside.

---

## Moving the coin one space

I need to see whether the coins are able to move into another grid and not move into grids that other coins are already in.
If the coin is in the first grid it will be removed from the grid.

### Test Data To Use

I will test moving multiple coins around and seeing what happens when they are to move into another coin and move when on the first grid.

### Expected Test Result

I expect the coin to disappear from the grid it is currently in and move into another grid.
In my first test when I tried to move the coin instead of moving one space to the left, another one of the same coin was made, it continued to duplicate itself and removed other coins in its way

![DTD testing 1.gif](images/DTD testing 1.gif)

In my next test I then added some code to make the grid the coin was originally in empty before moving the coin
![200DTD_MovingCoinOneSpaceDuplicationFixCode.png](images/200DTD_MovingCoinOneSpaceDuplicationFixCode.png)

---

This solved the issue of the coin duplicating itself however I still hadn't solved the issue of the coin moving into grids other coins are in and removing them
![DTD testing 2.gif](images/DTD testing 2.gif)
---

## Example Test Name

Example test description. Example test description.Example test description. Example test description.Example test description. Example test description.

### Test Data Used

Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

