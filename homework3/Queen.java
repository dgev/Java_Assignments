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

	@Override
	public boolean canMove(Figure figure, Position to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidMove(Figure figure, Position to) {
		// TODO Auto-generated method stub
		Bishop bishop = new Bishop(figure.getName(), figure.getColor(), figure.getPosition());
		Rook rook = new Rook(figure.getName(), figure.getColor(), figure.getPosition());
		return (bishop.isValidMove(bishop, to) || rook.isValidMove(rook, to));
	}
}
