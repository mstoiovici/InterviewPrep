package main.java.com.stoiovici.leetcode.matrix;

public class BattleshipsInBoard {

  // we have O(row x col) from the two loops  + time complexity from the recursive calls which is O(maximum(row, col)) because it can either find Xs
  // on all rows like a huge vertical ship or on all columns like a huge orizontal one (not botgh as the problem sais you'll get
  // a valid board where 2 ships don't touch each other
  public static int countBattleships(char [][] board){
    System.out.println("This is our board:");
    printBoard(board);
    int count =0;
    for(int row=0; row<board.length; row++){
      for(int col=0; col<board[row].length; col++){
        System.out.println("checking board[" + row +"][" +col +"]");
        if(board[row][col] == 'X'){
          count++;
          sink(board, row, col);
          System.out.println("After all points sinked we now have the board like this:");
          printBoard(board);
        }
      }
    }
    return count;
  }

  public static void sink (char[][] board, int row, int col){
    if (row < 0 || row >= board.length || col < 0
        || col >= board[row].length || board[row][col] != 'X') {
      return;
    }
    board[row][col] = '.';
    sink(board, row+1, col); //vertically
    // sink(board, row-1, col); //you don't need to sink previous row or column since you're already coming from there, you only move right and down
    sink(board, row, col+1); //horizontally
    // sink(board, row, col-1);
  }
  public static void printBoard(char[][] board){
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


  public static int countBattleshipsOptimized(char [][] board){
    System.out.println("This is our board:");
    printBoard(board);
    int count =0;
    for(int row=0; row<board.length; row++){
      for(int col=0; col<board[row].length; col++){
        System.out.println("checking board[" + row +"][" +col +"]");
        if(board[row][col] == '.'){
          continue;
        }
        if(row > 0 && board[row -1][col] == 'X'){
          continue;
        }
        if(col > 0 && board[row][col - 1] == 'X'){
          continue;
        }
        count++;
      }
    }
    return count;
  }



  public static void main (String[] args) {
    char[][] board = new char[4][4];
    // board[0][0] = 'X';
    // board[0][1] = '.';
    // board[0][2] = '.';
    // board[0][3] = 'X';
    // board[1][0] = '.';
    // board[1][1] = '.';
    // board[1][2] = '.';
    // board[1][3] = 'X';
    // board[2][0] = '.';
    // board[2][1] = '.';
    // board[2][2] = '.';
    // board[2][3] = 'X';
    // board[3][0] = '.';
    // board[3][1] = '.';
    // board[3][2] = '.';
    // board[3][3] = '.';
    //
    // System.out.print(countBattleships(board));

    board[0][0] = '.';
    board[0][1] = 'X';
    board[0][2] = '.';
    board[0][3] = '.';
    board[1][0] = '.';
    board[1][1] = 'X';
    board[1][2] = '.';
    board[1][3] = 'X';
    board[2][0] = '.';
    board[2][1] = '.';
    board[2][2] = '.';
    board[2][3] = 'X';
    board[3][0] = 'X';
    board[3][1] = 'X';
    board[3][2] = '.';
    board[3][3] = '.';

    System.out.print(countBattleshipsOptimized(board));
  }
}
