package am.homework3;

public class Knight extends Figure {

	public Knight(String name, String color, Position position) {
		super(4, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public static boolean knightCanMove(Figure figure, Position to) {
		if ((Math.abs(to.x - figure.getHorizontalPosition()) == 2
				&& Math.abs(to.y - figure.getVerticalPosition()) == 1)) {
			return true;
		} else if ((Math.abs(to.x - figure.getHorizontalPosition()) == 1
				&& Math.abs(to.y - figure.getVerticalPosition()) == 2)) {
			return true;
		}
		return false;

	}

	public static boolean isValidMoveByKnight(Figure figure, Position b) {
//		Knight knight = new Knight(figure.getName(), figure.getColor(), figure.getPosition());
		if (knightCanMove(figure, b)) {
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