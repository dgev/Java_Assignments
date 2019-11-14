package am.homework3;

/**
 * 
 * @author Diana
 *
 */

public class PlayChess {
	/**
	 * this is a program for starting a new chess game and making/validating moves
	 * @param args
	 */
	
	public static void main(String args[]) {
		
		new ChessBoard();	
		
		ChessBoard.move(new Figure("knight", "white", new Position(6, 0)), new Position(7, 2));
		System.out.println(ChessBoard.getFigure(new Position(7, 2)));
		System.out.println(ChessBoard.getFigure(new Position(6, 0)));
		ChessBoard.move(new Figure("pawn", "black", new Position(5, 6)), new Position(5, 5));
		System.out.println(ChessBoard.getFigure(new Position(5, 6)));
		System.out.println(ChessBoard.getFigure(new Position(5, 5)));
		ChessBoard.move(new Figure("pawn", "white", new Position(4, 1)), new Position(4, 2));
		System.out.println(ChessBoard.getFigure(new Position(4, 2)));
		ChessBoard.move(new Figure("queen", "white", new Position(3, 0)), new Position(2, 1));
		System.out.println(ChessBoard.getFigure(new Position(2,1)));
//		ChessBoard.move(new Figure("queen", "white", new Position(7, 4)), new Position(4,7));
		System.out.println(ChessBoard.diagonalPathIsFree(new Position(4,7), new Position(7, 4)));
	}
}
