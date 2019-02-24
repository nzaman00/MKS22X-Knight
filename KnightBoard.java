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
  
  
}
