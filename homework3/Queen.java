package am.homework3;

public class Queen extends Figure {

	public Queen(String name, String color, Position position) {
		super(1, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public Queen(String color, Position position, int piece) {
		this.setColor(color);
//		this.setName(name);
		this.setPiece(piece);
		this.setPosition(position);

		// TODO Auto-generated constructor stub
	}

	public boolean queenCanMove(Queen figure, Position to) {
		if (Math.abs(to.y - figure.getVerticalPosition()) == Math.abs(to.x - figure.getHorizontalPosition())) {
			return true;
		} else if (figure.getHorizontalPosition() == to.x || figure.getVerticalPosition() == to.y) {
			return true;
		}
		return false;
	}

	public static boolean isValidMoveByQueen(Figure figure, Position b) {
		Queen queen = new Queen(figure.getColor(), figure.getPosition(), 1);
		if ((queen.queenCanMove(queen, b))) {
			if (ChessBoard.diagonalPathIsFree(queen.getPosition(), b)
					|| ChessBoard.LinePathIsFree(queen.getPosition(), b)) {
				return true;
			}
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(queen.getColor())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
