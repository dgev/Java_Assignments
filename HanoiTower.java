package am.homework6;

public class HanoiTower {

	public static void solveHanowiTower(int numberOfDisks) {
		long startTime = System.nanoTime();
		recursiveSolver("1", "2", "3", numberOfDisks);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);
	}

	public static void recursiveSolver(String firstRod, String secondRod, String thirdRod, int numberOfDisks) {
		if (numberOfDisks == 1) {
			System.out.println("Put disk 1 into the rod number " + thirdRod);
		} else {
			recursiveSolver(firstRod, thirdRod, secondRod, numberOfDisks - 1);
			System.out.println("Put disk " + numberOfDisks + " into the rod number " + thirdRod);
			recursiveSolver(secondRod, firstRod, thirdRod, numberOfDisks - 1);

		}

	}

	public static void main(String args[]) {
		solveHanowiTower(5);

	}

}
