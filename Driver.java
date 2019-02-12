public class Driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(7);
    board.solve();
    System.out.println(board);
    QueenBoard board2 = new QueenBoard(8);
    System.out.println(board2.countSolutions());
  }
}
