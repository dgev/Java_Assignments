package am.homework3;

public class Figure {

	private int piece;
	private String color;
	private Position position;
	private String name;

	// Chess pieces
	public static final int QUEEN = 1;
	public static final int KING = 2;
	public static final int BISHOP = 3;
	public static final int KNIGHT = 4;
	public static final int ROOK = 5;
	public static final int PAWN = 6;

	public Figure() {

	}

	public Figure(String name, String color, Position position) {
		setColor(color);
		setPosition(position);
		setName(name);
	}

	public Figure(int piece, String color, Position position, String name) {
		setPiece(piece);
		setColor(color);
		setPosition(position);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (isValidName(name)) {
			this.name = name;
		}
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		if (isValidPiece(piece)) {
			this.piece = piece;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (isValidColor(color)) {
			this.color = color;
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		if (isValidPosition(position.x, position.y)) {
			this.position = position;
		}
	}

	public int getHorizontalPosition() {
		return position.x;
	}

	public int getVerticalPosition() {
		return position.y;
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

	private boolean isValidName(String name) {
		// TODO Auto-generated method stub
		String[] arrayOfFigures = { "QUEEN", "KING", "PAWN", "KNIGHT", "ROOK", "BISHOP" };
		for (String element : arrayOfFigures) {
			if (name.toUpperCase().equals(element)) {
				return true;
			}
		}
		return false;
	}

	public static boolean moveIsValid(Figure figure, Position b) {
		switch (figure.getName().toUpperCase()) {
		case "QUEEN":
			return (Bishop.isValidMoveByBishop(figure, b) || Rook.isValidMoveByRook(figure, b));
//			return Queen.isValidMoveByQueen(figure, b);
		case "KING":
			return King.isValidMoveByKing(figure, b);
		case "BISHOP":
			return Bishop.isValidMoveByBishop(figure, b);
		case "KNIGHT":
			return Knight.isValidMoveByKnight(figure, b);
		case "ROOK":
			return Rook.isValidMoveByRook(figure, b);
		case "PAWN":
			return Pawn.isValidMoveByPawn(figure, b);
		default:
			return false;
		}
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
