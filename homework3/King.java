package am.homework3;

public class King extends Figure{
	
	public King(String name, String color, Position position) {
		super(2, color, position, name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean kingCanMove(King figure, Position to) {
		if ((Math.abs(to.x - figure.getHorizontalPosition()) == 0 && Math.abs(to.y - figure.getVerticalPosition()) == 1)
				|| (Math.abs(to.x - figure.getHorizontalPosition()) == 1
						&& (Math.abs(to.y - figure.getVerticalPosition()) == 0)
								|| Math.abs(to.y - figure.getVerticalPosition()) == 1)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidMoveByKing(Figure figure, Position b) {
		King king = new King(figure.getName(), figure.getColor(), figure.getPosition());
		if (king.kingCanMove(king, b)) {
			if (ChessBoard.occupiedBy(b) != null) {
				if (ChessBoard.occupiedBy(b).getColor().equals(king.getColor())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
