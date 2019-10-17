package am.homework3;

public class Position {
	public int x = 0;
	public int y = 0;

	// constructor
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int[] getPosition() {
		int[] position = { x, y };
		return position;
	}
}
