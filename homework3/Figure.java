package am.homework3;

public class Figure {

	private int piece;
	private String color;
	private Position position;

	// Chess pieces
	public static final int QUEEN = 1;
	public static final int KING = 2;
	public static final int BISHOP = 3;
	public static final int KNIGHT = 4;
	public static final int ROOK = 5;
	public static final int PAWN = 6;

	public Figure(int piece, String color) {
		if (isValidPiece(piece) && isValidColor(color)) {
			this.piece = piece;
			this.color = color;
		}
	}

	public Figure(int piece, String color, Position position) {
		if (isValidPiece(piece) && isValidColor(color) && isValidPosition(position.x, position.y)) {
			this.piece = piece;
			this.color = color;
			this.position = position;
		}
	}

	public int getPiece() {
		return piece;
	}

	public String getColor() {
		return color;
	}

	public int getHorizontalPosition() {
		return position.x;
	}

	public int getVerticalPosition() {
		return position.y;
	}

	public Position getPosition() {
		return position;
	}

	private boolean isValidPosition(int x, int y) {
		// TODO Auto-generated method stub
		return x >= 0 && y >= 0 && x <= 7 && y <= 7;
	}

	private boolean isValidColor(String color) {
		// TODO Auto-generated method stub
		return color.equals("black") || color.equals("white");
	}

	private boolean isValidPiece(int piece) {
		// TODO Auto-generated method stub
		return piece >= 1 && piece <= 6;
	}

	public boolean pawnCanMove(Figure figure, Position to) {
		if (figure.getHorizontalPosition() == to.x) {
			if (figure.getVerticalPosition() == 1
					&& (to.y - figure.getVerticalPosition() == 2 || to.y - figure.getVerticalPosition() == 1)) {
				return true;
			} else if (to.y - figure.getVerticalPosition() == 1) {
				return true;
			}
		}
		return false;

	}

	public boolean rookCanMove(Figure figure, Position to) {
		if (figure.getHorizontalPosition() == to.x || figure.getVerticalPosition() == to.y) {
			return true;
		}
		return false;

	}

	public boolean bishopCanMove(Figure figure, Position to) {
		if (Math.abs(to.y - figure.getVerticalPosition()) == Math.abs(to.x - figure.getHorizontalPosition()))
			return true;
		return false;

	}

	public boolean knightCanMove(Figure figure, Position to) {
		if ((Math.abs(to.x - figure.getHorizontalPosition()) == 2 && Math.abs(to.y - figure.getVerticalPosition()) == 1)
				|| (Math.abs(to.x - figure.getHorizontalPosition()) == 1
						&& Math.abs(to.y - figure.getVerticalPosition()) == 2))
			return true;
		return false;

	}

	public boolean queenCanMove(Figure figure, Position to) {
		return figure.bishopCanMove(figure, to) || figure.rookCanMove(figure, to);

	}

	public boolean kingCanMove(Figure figure, Position to) {
		if ((Math.abs(to.x - figure.getHorizontalPosition()) == 0 && Math.abs(to.y - figure.getVerticalPosition()) == 1)
				|| (Math.abs(to.x - figure.getHorizontalPosition()) == 1
						&& (Math.abs(to.y - figure.getVerticalPosition()) == 0
								|| Math.abs(to.y - figure.getVerticalPosition()) == 1)))
			return true;
		return false;
	}

	public static String pieceToString(int piece) {
		switch (piece) {
		case PAWN:
			return "Pawn";
		case BISHOP:
			return "Bishop";
		case KNIGHT:
			return "Knight";
		case ROOK:
			return "Rook";
		case QUEEN:
			return "Queen";
		case KING:
			return "King";
		default:
			return null;
		}
	}
}
