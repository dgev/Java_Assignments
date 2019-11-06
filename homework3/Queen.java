package am.homework3;

public class Queen extends Figure {

	public Queen(String name, String color, Position position) {
		super(1, color, position, name);
		// TODO Auto-generated constructor stub
	}

	public Queen(String color, Position position, int piece) {
		this.setColor(color);
		this.setPiece(piece);
		this.setPosition(position);

		// TODO Auto-generated constructor stub
	}
}
