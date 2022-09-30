package main.java.com.stoiovici.leetcode.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountWeirdShapedIslands {
  public static int countIslandsRecursively(int[][] grid){
    int count=0;
    for (int row=0; row<=grid.length -1; row++){
      for(int col=0; col<=grid[row].length -1; col++){
        if(grid[row][col] == 0){
          continue;
        }
        count++;
        sinkCell(grid, row, col);
      }
    }
    return count;
  }

  public static int countIslandsBfs(int[][] grid) {
      int count=0;
      Set<int[]> visited = new HashSet<>();
      LinkedList<int[]> q = new LinkedList<>();

      for (int row=0; row<=grid.length -1; row++){
        for(int col=0; col<=grid[row].length -1; col++){
          if(grid[row][col] == 0){
            continue;
          }
          int[] currentCell = new int[]{row,col};
          if( !visited.contains(currentCell)){
            count++;
            q.addFirst(currentCell);
            System.out.println("q: [" + currentCell[0] + ", " + currentCell[1] + "]" );
          }
          while ((q.size() != 0)){
            int[] cell= q.getFirst();
            visited.add(cell);
            //check below if cell is visited
            int[] cellBelow = new int[]{cell[0]+1, cell[1]};
            if ((cellBelow[0]<= grid.length-1) && (visited.contains(cellBelow) == false)){
              System.out.println("Add below");
              q.addLast(cellBelow);
            }

//check before if cell is visited
            int[] cellBefore = new int[]{cell[0], cell[1]-1};
            if ((cellBefore[1] >=0) && (visited.contains(cellBefore) == false)){
              System.out.println("Add before");
              q.addLast(cellBefore);
            }

//check above if cell is visited
            int[] cellAbove = new int[]{cell[0]-1, cell[1]};
            if ((cellAbove[0]>=0) && (visited.contains(cellAbove) == false)){
              System.out.println("Add above");
              q.addLast(cellAbove);
            }
//check after if cell is visited
            int[] cellAfter = new int[]{cell[0], cell[1]+1};
            if ((cellAfter[1] <= grid[cell[0]].length -1) && (visited.contains(cellAfter) == false)){
              System.out.println("Add after");
              q.addLast(cellAfter);
            }

          }

        }
      }
      return count;
    }


  public static void sinkCell(int [][] grid, int row, int col){
    grid[row][col] = 0;
//sink below
    if(row+1 <= grid.length-1 && grid[row+1][col] ==1){
      sinkCell(grid, row+1, col);
    }
//sink before
    if(col-1 >=0 && grid[row][col-1] ==1){
      sinkCell(grid, row, col-1);
    }

//sink above
    if(row-1>=0 && grid[row-1][col] ==1){
      sinkCell(grid, row-1, col);
    }
//sink after
    if(col+1 <= grid[row].length -1 && grid[row][col+1] ==1){
      sinkCell(grid, row, col+1);
    }
  }


  public static void printBoard(int[][] board){
    System.out.print("[ ");
    for(int row=0; row<board.length; row++){
      System.out.println();
      System.out.print('[');
      for(int col=0; col<board[row].length; col++){
        System.out.print(board[row][col] );
        System.out.print(',');
      }
      System.out.print(']');
    }
    System.out.println();
    System.out.print(']');
  }

  public static void main(String[] args) {
    int[][] grid = new int[5][6];
    grid[1][1] = 1;
    grid[1][2] = 1;
    grid[2][2] = 1;
    grid[3][2] = 1;
    grid[3][3] = 1;
    grid[3][5] = 1;
    grid[4][0] = 1;
    grid[4][1] = 1;
    grid[4][2] = 1;
    grid[4][3] = 1;
    grid[4][5] = 1;
    // grid[1][4] = 1;
    // grid[2][4] = 1;
    // grid[2][5] = 1;
    // grid[0][3] = 1;
    // grid[0][4] = 1;

    //printBoard(grid);
    //System.out.println(countIslandsRecursively(grid));
    System.out.println( countIslandsBfs(grid));
  }
}
