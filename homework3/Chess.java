package am.homework3;

public class Chess {
	public static void main(String args[]) {
		Position position = new Position(0, 5);
		Figure pawn = new Figure(6, "white", position);
		new ChessBoard();
//		System.out.println(ChessBoard.getFigure(position));
		System.out.println(ChessBoard.moveIsValid(pawn, new Position(0,2)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(5, "white", position), new Position(0, 1)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(4, "white", position), new Position(2,2)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(3, "white", position), new Position(2,0)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(2, "white", position), new Position(6,7)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(1, "white", position), new Position(4,0)));
		

	}
}
