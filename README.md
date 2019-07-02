# Conway's game of life

## Description

Develop an API that given a cell'state returns its new state.

### Rules
1. Any live cell with fewer than two live neighbors dies.
2. Any live cell with two or three live neighbors lives.
3. Any live cell with more than three live neighbors dies.
4. Any dead cell with exactly three live neighbors becomes a live cell.
5. Each cell could have a maximum of 8 neighbors.

## UnitTests
Run `mvn clean test`
