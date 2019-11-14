package am.homework3;

public class King extends Figure {

	public King(String name, String color, Position position) {
		super(2, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public static boolean kingCanMove(Figure figure, Position to) {
		boolean canMove = false;
		if (Math.abs(to.x - figure.getHorizontalPosition()) == 0
				&& Math.abs(to.y - figure.getVerticalPosition()) == 1) {
			canMove = true;
		} else if (Math.abs(to.x - figure.getHorizontalPosition()) == 1) {
			if (Math.abs(to.y - figure.getVerticalPosition()) == 0
					|| Math.abs(to.y - figure.getVerticalPosition()) == 1) {
				canMove = true;
			}
		}
		return canMove;
	}

	public static boolean isValidMoveByKing(Figure figure, Position b) {
//		King king = new King(figure.getName(), figure.getColor(), figure.getPosition());
		if (kingCanMove(figure, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(figure.getColor())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
