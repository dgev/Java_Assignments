package am.homework3;

public class ChessBoard {

	public static int numPieces = 16;
	public static int numPlayers = 2;
	public static int numFigures = numPieces * numPlayers;
	private static Figure[] figures = new Figure[numFigures];

	/**
	 * ChessBoard constructor initializes the board
	 */

	public ChessBoard() {
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

	}

	public ChessBoard(Figure[] newFigures) {
		figures = newFigures;
	}

	/**
	 * getFigure method receives position as a parameter and returns the name of the
	 * piece
	 * 
	 * @param position
	 * @return String
	 */

	public static String getFigure(Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i] != null && figures[i].getHorizontalPosition() == position.x
					&& figures[i].getVerticalPosition() == position.y) {
				return figures[i].getColor() + " " + occupiedBy(position).getName();
			}
		}
		return "There is no figure in the specified position!";
	}

	/**
	 * 
	 * @param position
	 * @return a figure in a specified position
	 */

	public static Figure occupiedBy(Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i].getHorizontalPosition() == position.x && figures[i].getVerticalPosition() == position.y) {
				return figures[i];
			}
		}
		return null;
	}

	public static Figure getKing(String color) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i] != null && figures[i].getName().equalsIgnoreCase("king")
					&& !figures[i].getColor().equals(color)) {
				return figures[i];
			}
		}
		return null;
	}

	/**
	 * removes a figure from the board
	 * 
	 * @param position
	 */

	public static void remove(Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i].getHorizontalPosition() == position.x && figures[i].getVerticalPosition() == position.y) {
				figures[i] = null;
				break;
			}
		}
	}

	/**
	 * changes the position of a specified figure
	 * 
	 * @param figure
	 * @param position
	 */

	public static void changeFigure(Figure figure, Position position) {
		for (int i = 0; i < numFigures; i++) {
			if (figures[i] == null || (figures[i].getHorizontalPosition() == position.x
					&& figures[i].getVerticalPosition() == position.y)) {
				figure.setPosition(position);
				figures[i] = figure;
				break;
			}
		}
	}

	/**
	 * checks whether the diagonal path between two positions is free or not
	 * 
	 * @param from
	 * @param to
	 * @return
	 */

	public static boolean diagonalPathIsFree(Position from, Position to) {
		int x = from.x;
		int y = from.y;
		if (x == to.x) {
			return false;
		} else if (x > to.x) {
			while (x != to.x + 1) {
				y = (y < to.y ? y + 1 : y - 1);
				x--;
				if (occupiedBy(new Position(x, y)) != null) {
					return false;
				}
			}
			return true;
		} else {
			while (x != to.x - 1) {
				x++;
				y = (y < to.y ? y + 1 : y - 1);
				if (occupiedBy(new Position(x, y)) != null) {
					return false;
				}
			}
			return true;
		}
	}

	
	/**
	 * checks whether the vertical path between two positions is free
	 * 
	 * @param from
	 * @param to
	 * @return
	 */

	public static boolean canMoveVertically(Position from, Position to) {
		int x = from.x;
		int y = from.y;
		if (y > to.y) {
			while (y != to.y - 1) {
				y--;
				if (occupiedBy(new Position(x, y)) != null) {
					return false;
				}
			}
			return true;
		} else {
			while (y != to.y - 1) {
				y++;
				if (occupiedBy(new Position(x, y)) != null) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * validates linear paths
	 * 
	 * @param from
	 * @param to
	 * @return
	 */

	public static boolean linePathIsFree(Position from, Position to) {
		if (from.x == to.x) {
			return canMoveVertically(from, to);
		} else if (from.y == to.y) {
			return canMoveVertically(new Position(from.y, from.x), to);
		}
		return false;
	}

	/**
	 * moves a figure from one position to another
	 * 
	 * @param figure
	 * @param b
	 */

	public static void move(Figure figure, Position b) {
		if (Figure.moveIsValid(figure, b)) {
			remove(figure.getPosition());
			changeFigure(figure, b);
			System.out.println("Figure moved successfully!");
			Figure kingFigure = getKing(figure.getColor());
			if(kingFigure != null){
				if(Figure.moveIsValid(figure, kingFigure.getPosition())) {
					System.out.println("check to " + kingFigure.getColor());
				}
			}
		} else {
			System.out.println("Invalid Move!");
		}
	}

}
