package am.homework3;

public class Rook extends Figure {

	public Rook(String name, String color, Position position) {
		super(5, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public boolean rookCanMove(Rook figure, Position to) {
		if (figure.getHorizontalPosition() == to.x || figure.getVerticalPosition() == to.y) {
			return true;
		}
		return false;

	}

	public static boolean isValidMoveByRook(Figure figure, Position b) {
		Rook rook = new Rook(figure.getName(), figure.getColor(), figure.getPosition());
		if (rook.rookCanMove(rook, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(rook.getColor())) {
					return false;
				}
			}
			if (Math.abs(b.y - rook.getVerticalPosition()) > 1 || Math.abs(b.x - rook.getHorizontalPosition()) > 1) {
				if (ChessBoard.linePathIsFree(rook.getPosition(), b)) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;

	}

}
