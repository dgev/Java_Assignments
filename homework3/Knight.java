public class Knight extends Figure {

	public Knight(String name, String color, Position position) {
		super(4, color, position, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Figure figure, Position to) {
		if ((Math.abs(to.x - figure.getHorizontalPosition()) == 2
				&& Math.abs(to.y - figure.getVerticalPosition()) == 1)) {
			return true;
		} else if ((Math.abs(to.x - figure.getHorizontalPosition()) == 1
				&& Math.abs(to.y - figure.getVerticalPosition()) == 2)) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isValidMove(Figure figure, Position b) {
		if (canMove(figure, b)) {
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