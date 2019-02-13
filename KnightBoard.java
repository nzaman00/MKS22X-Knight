public class KnightBoard{
  private int[][] board;
  private int[][] moves;
  public KnightBoard(int startingRows,int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    for(int i =0; i < board.length;i++ ){
      for(int j = 0; j < board[0].length;j++){
        board[i][j]= 0;
      }
    }
  }
  public String toString(){
    String s = "";
  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[0].length; j++) {
  			if (board[i][j] < 10) s = s + " " + board[i][j] + " ";
  			else s += board[i][j] + " ";
  		}
  		s+="\n";
  	 }
    return s;
    }

}
