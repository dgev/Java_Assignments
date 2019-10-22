package am.homework3;

public class ChessBoard {

	public static int numPieces = 16;
	public static int numPlayers = 2;
	public static int numFigures = numPieces * numPlayers;
	private static Figure[] figures = new Figure[numFigures];

	public ChessBoard() {

	}

	public ChessBoard(Figure[] newFigures) {
		figures = newFigures;
	}

	public static String getFigure(Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i].getHorizontalPosition() == position.x && figures[i].getVerticalPosition() == position.y) {
				return figures[i].getColor() + " " + Figure.pieceToString(figures[i].getPiece());
			}
		}
		return null;
	}

	public static Figure occupiedBy(Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i].getHorizontalPosition() == position.x && figures[i].getVerticalPosition() == position.y) {
				return figures[i];
			}
		}
		return null;
	}

	public static boolean diagonalPathIsFree(Position from, Position to) {
		if (from.x > to.x) {
			while (from.x != to.x || from.y != to.y) {
				from.y = (from.y < to.y ? from.y+1 : from.y-1);
				from.x--;
				if (occupiedBy(from) != null) {
					return false;
				}
			}
			return true;
		} else {
			while (from.x != to.x || from.y != to.y) {
				from.x++;
				from.y = (from.y < to.y ? from.y+1 : from.y-1);
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
				while (from.y < to.y) {
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

	public static boolean validateMove(Figure figure, Position b) {
		return Figure.moveIsValid(figure, b);
	}

}
