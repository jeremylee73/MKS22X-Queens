public class QueenBoard {
  private int[][]board;
  private int size;

  public QueenBoard(int size){
    board = new int[size][size];
    this.size = size;
  }

  private boolean addQueen(int r, int c){
    for (int row=0; row<size; row++){
      for (int col=0; col<size; col++){
        if (row == r || col == c){
          board[row][col] += 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft<size-r; rowsLeft++){
      for (int colsLeft = c; colsLeft<size-c; colsLeft++){
        if (rowsLeft-r == colsLeft-c){
          board[rowsLeft][colsLeft] += 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft<size-r; rowsLeft++){
      for (int colsLeft = c; colsLeft>=0; colsLeft--){
        if (rowsLeft-r == Math.abs(colsLeft-c)){
          board[rowsLeft][colsLeft] += 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft>=0; rowsLeft--){
      for (int colsLeft = c; colsLeft<size-c; colsLeft++){
        if (Math.abs(rowsLeft-r) == colsLeft-c){
          board[rowsLeft][colsLeft] += 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft>=0; rowsLeft--){
      for (int colsLeft = c; colsLeft>=0; colsLeft--){
        if (Math.abs(rowsLeft-r) == Math.abs(colsLeft-c)){
          board[rowsLeft][colsLeft] += 1;
        }
      }
    }
    board[r][c] = -1;
    return true;
  }

  private boolean removeQueen(int r, int c){
    for (int row=0; row<size; row++){
      for (int col=0; col<size; col++){
        if (row == r || col == c){
          board[row][col] -= 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft<size-r; rowsLeft++){
      for (int colsLeft = c; colsLeft<size-c; colsLeft++){
        if (rowsLeft-r == colsLeft-c){
          board[rowsLeft][colsLeft] -= 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft<size-r; rowsLeft++){
      for (int colsLeft = c; colsLeft>=0; colsLeft--){
        if (rowsLeft-r == Math.abs(colsLeft-c)){
          board[rowsLeft][colsLeft] -= 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft>=0; rowsLeft--){
      for (int colsLeft = c; colsLeft<size-c; colsLeft++){
        if (Math.abs(rowsLeft-r) == colsLeft-c){
          board[rowsLeft][colsLeft] -= 1;
        }
      }
    }
    for (int rowsLeft = r; rowsLeft>=0; rowsLeft--){
      for (int colsLeft = c; colsLeft>=0; colsLeft--){
        if (Math.abs(rowsLeft-r) == Math.abs(colsLeft-c)){
          board[rowsLeft][colsLeft] -= 1;
        }
      }
    }
    board[r][c] = 0;
    return true;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String ans = "";
    for (int row = 0; row<size; row++){
      for (int col = 0; col<size; col++){
        if (board[row][col] == -1){
          ans += "Q";
        } else {
          ans += "_";
        }
      }
      ans += "\n";
    }
    return ans;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    addQueen(1, 1);
    removeQueen(1,1);
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }
}
