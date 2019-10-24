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

	}
}
