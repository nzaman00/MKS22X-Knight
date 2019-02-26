public class KnightBoard{
  private int[][] board;
  private int[] movesR = {-2, -1, 1, 2, 2, 1, -1, -2};
  private int[] movesC = {1, 2, 2, 1, -1, -2, -2, -1};
  
  public KnightBoard(int startingRows,int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
  }
  
  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) {
          if (board.length * board[0].length >= 10) {
            ans += " _ ";
          } else {
            ans += "_ ";
          }
        } else {
          if (board.length * board[0].length >= 10 && board[i][j] / 10 == 0) {
            ans = ans + " " + board[i][j] + " ";
          } else {
            ans = ans + board[i][j] + " ";
          }
        }
      }
      ans += '\n';
    }
    return ans;
  }
  
  public boolean addKnight(int row, int col, int level) {
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      if (board[row][col] == 0) {
        board[row][col] = level;
        return true;
      }
    }
    return false;
  }
  
  public boolean removeKnight(int row, int col) {
    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
      if (board[row][col] != 0) {
        board[row][col] = 0;
        return true;
      }
    }
    return false;
  }
  
  public boolean solve(int startingRow, int startingCol) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[startingRow].length) {
      throw new IllegalArgumentException();
    }
    return solveH(0,0,1);
  }

  private boolean solveH(int row, int col, int level) {
    if (level > board.length * board[0].length) { 
      return true;
    } else {
      if (addKnight(row, col, level)) {
        for (int i = 0; i < movesR.length; i++) { 
          if (solveH(row + movesR[i], col + movesC[i], level + 1)) {
            return true;
          }
        }
        removeKnight(row, col);
      }
      return false;
    }
  }
  
  public int countSolutions(int startingRow, int startingCol) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[startingRow].length) {
      throw new IllegalArgumentException();
    }
    return countH(0,0,1);
  }

  private int countH(int row, int col, int level) {
    int total = 0;
    if (addKnight(row, col, level)) {
      if (level == board.length * board[0].length) { 
        removeKnight(row, col);
        return 1;
      } else {
        for (int i = 0; i < movesR.length; i++) { 
          total += countH(row + movesR[i], col + movesC[i], level + 1);
        }
      }
      removeKnight(row, col);
    }
    return total;
  }
  
}
