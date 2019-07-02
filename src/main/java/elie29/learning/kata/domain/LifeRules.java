package elie29.learning.kata.domain;

public class LifeRules
{

   public static CellState getNewState(CellState state, int liveNeighbors)
   {
      if (liveNeighbors < 0 || liveNeighbors > 8) {
         throw new UnsupportedOperationException();
      }

      // Any live cell with fewer than two live neighbors dies.
      // Any live cell with more than three live neighbors dies.
      if (liveNeighbors < 2 || liveNeighbors > 3) {
         return CellState.DEAD;
      }

      // Any dead cell with exactly three live neighbors becomes a live cell.
      if (liveNeighbors == 3) {
         return CellState.ALIVE;
      }

      // status does not change for other cells
      return state;
   }
}
