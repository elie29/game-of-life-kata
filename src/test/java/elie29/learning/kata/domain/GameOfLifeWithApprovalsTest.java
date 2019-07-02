package elie29.learning.kata.domain;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter(JunitReporter.class)
public class GameOfLifeWithApprovalsTest
{

   @Test
   public void aliveCellWithFewerThanTwoNeighborCellsDies()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.ALIVE},
         new Integer[]{0, 1}
      );
   }

   @Test
   public void aliveCellWithTwoOrThreeNeighborCellsLives()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.ALIVE},
         new Integer[]{2, 3}
      );
   }

   @Test
   public void deadCellWithTwoNeighborCellsRemainsDead()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.DEAD},
         new Integer[]{2}
      );
   }

   @Test
   public void aliveCellWithWithMoreThanThreeNeighborCellsDies()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.ALIVE},
         new Integer[]{4, 5, 6, 7, 8}
      );
   }

   @Test
   public void deadCellWithWithThreeNeighborCellsLives()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.DEAD},
         new Integer[]{3}
      );
   }

   @Test
   public void cellWithMoreThanEightOrNegativeNeighborCellsThrowException()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.DEAD, CellState.ALIVE},
         new Integer[]{-1, 9, 10}
      );
   }

   @Test
   public void allTestsInOneTestCombinations()
   {
      CombinationApprovals.verifyAllCombinations(LifeRules::getNewState,
         new CellState[]{CellState.DEAD, CellState.ALIVE},
         new Integer[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
      );
   }
}
