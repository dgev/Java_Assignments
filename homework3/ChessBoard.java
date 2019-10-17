package am.homework3;

public class ChessBoard {

	public static int numPieces = 16;
	public static int numPlayers = 2;
	public static int numFigures = numPieces * numPlayers;

	private static Figure[][] figures;

	public ChessBoard() {
		figures = new Figure[numPlayers][numPieces];
		// initialize pawns
		for (int j = 0; j < numPieces / 2; j++) {
			figures[1][j] = new Figure(6, "white", new Position(j, 1));
			figures[1][j + 8] = new Figure(6, "black", new Position(j, 6));
		}
		// rooks
		figures[0][0] = new Figure(5, "white", new Position(0, 0));
		figures[0][1] = new Figure(5, "white", new Position(7, 0));
		figures[0][2] = new Figure(5, "black", new Position(0, 7));
		figures[0][3] = new Figure(5, "black", new Position(7, 7));
		// knights
		figures[0][4] = new Figure(4, "white", new Position(1, 0));
		figures[0][5] = new Figure(4, "white", new Position(6, 0));
		figures[0][6] = new Figure(4, "black", new Position(1, 7));
		figures[0][7] = new Figure(4, "black", new Position(6, 7));
		// bishops
		figures[0][8] = new Figure(3, "white", new Position(2, 0));
		figures[0][9] = new Figure(3, "white", new Position(5, 0));
		figures[0][10] = new Figure(3, "black", new Position(2, 7));
		figures[0][11] = new Figure(3, "black", new Position(5, 7));
		// queens and kings
		figures[0][12] = new Figure(2, "white", new Position(3, 0));
		figures[0][13] = new Figure(2, "white", new Position(4, 0));
		figures[0][14] = new Figure(1, "black", new Position(3, 7));
		figures[0][15] = new Figure(1, "black", new Position(4, 7));

	}

	public static String getFigure(Position position) {
		for (int i = 0; i < numPlayers; i++) {
			for (int j = 0; j < numPieces; j++) {
				if (figures[i][j].getHorizontalPosition() == position.x
						&& figures[i][j].getVerticalPosition() == position.y)
					return figures[i][j].getColor() + " " + Figure.pieceToString(figures[i][j].getPiece());
			}
		}
		return null;
	}

	public static Figure occupiedBy(Position position) {
		for (int i = 0; i < numPlayers; i++) {
			for (int j = 0; j < numPieces; j++) {
				if (figures[i][j].getHorizontalPosition() == position.x
						&& figures[i][j].getVerticalPosition() == position.y)
					return figures[i][j];
			}
		}
		return null;
	}

	public static boolean diagonalPathIsFree(Position from, Position to) {
		if (from.x > to.x) {
			while (from.x != to.x || from.y != to.y) {
				from.x--;
				from.y--;
				if (occupiedBy(from) != null) {
					return false;
				}
			}
			return true;
		} else {
			while (from.x != to.x || from.y != to.y) {
				from.x++;
				from.y++;
				if (occupiedBy(from) != null) {
					return false;
				}
			}
			return true;
		}
	}

	public static boolean LinePathIsFree(Position from, Position to) {
		if (from.y == to.y) {
			if (from.x > to.x) {
				while (from.x != to.x) {
					from.x--;
					if (occupiedBy(from) != null) {
						return false;
					}
				}
				return true;
			} else {
				while (from.x != to.x) {
					from.x++;
					if (occupiedBy(from) != null) {
						return false;
					}
				}
				return true;
			}
		} else if (from.x == to.x) {
			if (from.y > to.y) {
				while (from.y != to.y) {
					from.y--;
					if (occupiedBy(from) != null) {
						return false;
					}
				}
				return true;
			} else {
				while (from.y != to.y) {
					from.y++;
					if (occupiedBy(from) != null) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	public static boolean moveIsValid(Figure figure, Position b) {
		Figure figureAtTo = occupiedBy(b);
		switch (figure.getPiece()) {
		case 1:
			if (figure.queenCanMove(figure, b)) {
				if (diagonalPathIsFree(figure.getPosition(), b) || LinePathIsFree(figure.getPosition(), b)) {
					if (figureAtTo != null) {
						if (figureAtTo.getColor().equals(figure.getColor())) {
							return false;
						}
						return true;
					}
				}
				return false;
			}
			return false;

		case 2:
			if (figure.kingCanMove(figure, b)) {
				if (figureAtTo != null) {
					if (figureAtTo.getColor().equals(figure.getColor())) {
						return false;
					}
				}
				return true;
			}
			return false;

		case 3:
			if (figure.bishopCanMove(figure, b)) {
				if (Math.abs(b.y - figure.getVerticalPosition()) > 1) {
					if (diagonalPathIsFree(figure.getPosition(), b)) {
						if (figureAtTo != null) {
							if (figureAtTo.getColor().equals(figure.getColor())) {
								return false;
							}
						}
						return true;
					}
					return false;
				}
				return true;
			}
			return false;

		case 4:
			if (figure.knightCanMove(figure, b)) {
				if (figureAtTo != null) {
					if (figureAtTo.getColor().equals(figure.getColor())) {
						return false;
					}
				}
				return true;
			}
			return false;

		case 5:
			if (figure.rookCanMove(figure, b)) {
				if (figureAtTo != null) {
					if (figureAtTo.getColor().equals(figure.getColor())) {
						return false;
					}
					if (Math.abs(b.y - figure.getVerticalPosition()) > 1
							|| Math.abs(b.x - figure.getHorizontalPosition()) > 1) {
						if (LinePathIsFree(figure.getPosition(), b)) {
							return true;
						}
						return false;
					}
					return true;
				}
			}
			return false;

		case 6:
			if (figure.pawnCanMove(figure, b)) {
				
				if (figureAtTo != null) {
						if(figureAtTo.getColor().equals(figure.getColor()))
							return false;
					}
				if ((Math.abs(b.y - figure.getVerticalPosition()) > 1)) {
					return LinePathIsFree(figure.getPosition(), b);
				}
				return true;
			}
		return false;
			
		default:
			return false;

		}
	}
}
