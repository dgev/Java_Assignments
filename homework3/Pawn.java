package am.homework3;

public class Pawn extends Figure {

	public Pawn(String name, String color, Position position) {
		super(6, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public Pawn(Figure pawn) {
		super(6, pawn.getColor(), pawn.getPosition(), pawn.getName());
		// TODO Auto-generated constructor stub
	}

	public static boolean pawnCanMove(Figure figure, Position to) {
		if (figure.getHorizontalPosition() == to.x && ChessBoard.occupiedBy(to) == null) {
			if ("white".contentEquals(figure.getColor())) {
				if ((figure.getVerticalPosition() == 1 && to.y - figure.getVerticalPosition() == 2)
						|| to.y - figure.getVerticalPosition() == 1) {
					return true;
				}
			} else if ((figure.getVerticalPosition() == 6 && (figure.getVerticalPosition() - to.y == 2)
					|| figure.getVerticalPosition() - to.y == 1)) {
				return true;
			}
		} else if (Math.abs(figure.getHorizontalPosition() - to.x) == 1) {
			if (("white".contentEquals(figure.getColor()) && to.y - figure.getVerticalPosition() == 1)
					|| (figure.getVerticalPosition() - to.y == 1 && "black".contentEquals(figure.getColor()))) {
				if (!ChessBoard.occupiedBy(to).getColor().equals(figure.getColor())) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isValidMoveByPawn(Figure figure, Position b) {
//		Pawn pawn = new Pawn(figure.getName(), figure.getColor(), figure.getPosition());
		if (ChessBoard.occupiedBy(b) != null) {
			if (ChessBoard.occupiedBy(b).getColor().equals(figure.getColor()))
				return pawnCanMove(figure, b);
		} else if (pawnCanMove(figure, b)) {
			return ChessBoard.linePathIsFree(figure.getPosition(), b);
		}
		return false;
	}
}
