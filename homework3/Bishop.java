package am.homework3;

public class Bishop extends Figure {

	public Bishop(String name, String color, Position position) {
		super(3, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public static boolean bishopCanMove(Figure figure, Position to) {
		if (Math.abs(to.y - figure.getVerticalPosition()) == Math.abs(to.x - figure.getHorizontalPosition()))
			return true;
		return false;

	}

	public static boolean isValidMoveByBishop(Figure figure, Position b) {
//		Bishop bishop = new Bishop("bishop", figure.getColor(), figure.getPosition());
		if (bishopCanMove(figure, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(figure.getColor())) {
					return false;
				}
			}
			if (Math.abs(b.y - figure.getVerticalPosition()) > 1) {
				return (ChessBoard.diagonalPathIsFree(figure.getPosition(), b));
			}
			return true;
		}
		return false;
	}

}
