package elie29.learning.kata.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GameOfLifeWithJUnitParamsTest
{

   @Test
   @Parameters({
      "0",
      "1"
   })
   public void aliveCellWithFewerThanTwoNeighborCellsDies(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.ALIVE;

      // When
      CellState result = LifeRules.getNewState(currentState, liveNeighbors);

      // Than
      assertThat(result, is(CellState.DEAD));
   }

   @Test
   @Parameters({
      "2",
      "3"
   })
   public void aliveCellWithTwoOrThreeNeighborCellsLives(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.ALIVE;

      // When
      CellState result = LifeRules.getNewState(currentState, liveNeighbors);

      // Than
      assertThat(result, is(CellState.ALIVE));
   }

   @Test
   @Parameters({
      "2"
   })
   public void deadCellWithTwoNeighborCellsRemainsDead(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.DEAD;

      // When
      CellState result = LifeRules.getNewState(currentState, liveNeighbors);

      // Than
      assertThat(result, is(CellState.DEAD));
   }

   @Test
   @Parameters({
      "4",
      "5",
      "6",
      "7",
      "8"
   })
   public void aliveCellWithWithMoreThanThreeNeighborCellsDies(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.ALIVE;

      // When
      CellState result = LifeRules.getNewState(currentState, liveNeighbors);

      // Than
      assertThat(result, is(CellState.DEAD));
   }

   @Test
   @Parameters({
      "3"
   })
   public void deadCellWithWithThreeNeighborCellsLives(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.DEAD;

      // When
      CellState result = LifeRules.getNewState(currentState, liveNeighbors);

      // Than
      assertThat(result, is(CellState.ALIVE));
   }

   @Test(expected = UnsupportedOperationException.class)
   @Parameters({
      "-1",
      "9",
      "10"
   })
   public void cellWithMoreThanEightOrNegativeNeighborCellsThrowException(int liveNeighbors)
   {
      // Given
      CellState currentState = CellState.DEAD;

      // When / than
      LifeRules.getNewState(currentState, liveNeighbors);
   }
}
