package am.homework3;

public class Rook extends Figure {

	public Rook(String name, String color, Position position) {
		super(5, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public static boolean rookCanMove(Figure figure, Position to) {
		if (figure.getHorizontalPosition() == to.x || figure.getVerticalPosition() == to.y) {
			return true;
		}
		return false;

	}

	public static boolean isValidMoveByRook(Figure figure, Position b) {
//		Rook rook = new Rook(figure.getName(), figure.getColor(), figure.getPosition());
		if (rookCanMove(figure, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(figure.getColor())) {
					return false;
				}
			}
			if (Math.abs(b.y - figure.getVerticalPosition()) > 1 || Math.abs(b.x - figure.getHorizontalPosition()) > 1) {
				if (ChessBoard.linePathIsFree(figure.getPosition(), b)) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;

	}

}
