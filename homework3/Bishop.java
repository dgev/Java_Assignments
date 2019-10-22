package am.homework3;

public class Bishop extends Figure{
	
	public Bishop(String name, String color, Position position) {
		super(3, color, position, name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean bishopCanMove(Bishop figure, Position to) {
		if (Math.abs(to.y - figure.getVerticalPosition()) == Math.abs(to.x - figure.getHorizontalPosition()))
			return true;
		return false;

	}
	
	public static boolean isValidMoveByBishop(Figure figure, Position b) {
		Bishop bishop = new Bishop(figure.getName(), figure.getColor(), figure.getPosition());
		if (bishop.bishopCanMove(bishop, b)) {
			if (Math.abs(b.y - bishop.getVerticalPosition()) > 1) {
				if (ChessBoard.diagonalPathIsFree(bishop.getPosition(), b)) {
					if (ChessBoard.occupiedBy(b) != null) {
						if (ChessBoard.occupiedBy(b).getColor().equals(bishop.getColor())) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

}
