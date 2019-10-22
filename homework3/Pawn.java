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

	public boolean pawnCanMove(Pawn figure, Position to) {
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

	public static boolean isValidMoveByPawn(Figure figure, Position b) {
		Pawn pawn = new Pawn(figure.getName(), figure.getColor(), figure.getPosition());
		if (pawn.pawnCanMove(pawn, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(pawn.getColor()))
					return false;
			}
			if ((Math.abs(b.y - pawn.getVerticalPosition()) > 1)) {
				return ChessBoard.LinePathIsFree(pawn.getPosition(), b);
			}
			return true;
		}
		return false;
	}
}
