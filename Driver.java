public class Driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(2);
    board.solve();
    System.out.println(board);
  }
}
