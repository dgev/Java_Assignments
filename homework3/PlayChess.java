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
		
		ChessBoard.move(new Knight("knight", "white", new Position(6, 0)), new Position(7, 2));
		System.out.println(ChessBoard.getFigure(new Position(7, 2)));
		System.out.println(ChessBoard.getFigure(new Position(6, 0)));
		ChessBoard.move(new Pawn("pawn", "black", new Position(3, 6)), new Position(3, 4));
		System.out.println(ChessBoard.getFigure(new Position(3, 6)));
		System.out.println(ChessBoard.getFigure(new Position(3, 4)));
		ChessBoard.move(new Pawn("pawn", "white", new Position(2, 1)), new Position(2, 2));
		System.out.println(ChessBoard.getFigure(new Position(2, 2)));
		
		ChessBoard.move(new Queen("queen", "white", new Position(3, 0)), new Position(0, 3));
		System.out.println(ChessBoard.getFigure(new Position(0,3)));
	}
}
