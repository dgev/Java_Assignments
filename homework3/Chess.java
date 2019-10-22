package am.homework3;

public class Chess {
	private static Figure[] figures = new Figure[32];

	public static void main(String args[]) {
		// initialize pawns
		for (int j = 16; j < 24; ++j) {
			figures[j] = new Pawn("pawn", "white", new Position(j - 16, 1));
			figures[j + 8] = new Pawn("pawn", "black", new Position(j - 16, 6));
		}
		// rooks
		figures[0] = new Figure("rook", "white", new Position(0, 0));
		figures[1] = new Figure("rook", "white", new Position(7, 0));
		figures[2] = new Figure("rook", "black", new Position(0, 7));
		figures[3] = new Figure("rook", "black", new Position(7, 7));
		// knights
		figures[4] = new Figure("knight", "white", new Position(1, 0));
		figures[5] = new Figure("knight", "white", new Position(6, 0));
		figures[6] = new Figure("knight", "black", new Position(1, 7));
		figures[7] = new Figure("knight", "black", new Position(6, 7));
		// bishops
		figures[8] = new Figure("bishop", "white", new Position(2, 0));
		figures[9] = new Figure("bishop", "white", new Position(5, 0));
		figures[10] = new Figure("bishop", "black", new Position(2, 7));
		figures[11] = new Figure("bishop", "black", new Position(5, 7));
		// queens and kings
		figures[12] = new Figure("queen", "white", new Position(3, 0));
		figures[13] = new Figure("king", "white", new Position(4, 0));
		figures[14] = new Figure("queen", "black", new Position(3, 7));
		figures[15] = new Figure("king", "black", new Position(4, 7));
		
		new ChessBoard(figures);
		
//		System.out.println(ChessBoard.getFigure(position));
//		System.out.println(ChessBoard.moveIsValid(pawn, new Position(0,2)));
//		System.out.println(ChessBoard.moveIsValid(new Figure(5, "white", position), new Position(0, 1)));
//		System.out.println(ChessBoard.validateMove(new Figure("rook", "white", new Position(3, 4)), new Position(3,6)));
//		System.out.println(ChessBoard.validateMove(new Figure("bishop", "white", new Position(3, 5)), new Position(6,2)));
//		System.out.println(ChessBoard.validateMove(new Figure("queen", "white", new Position(3, 5)), new Position(0, 2)));
//		System.out.println(ChessBoard.validateMove(new Figure("king", "white", new Position(3, 5)), new Position(3, 7)));

	}
}
