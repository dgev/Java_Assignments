package am.homework6;

import java.util.Stack;

public class HanoiTower {

	public static void solveHanowiTower(int numberOfDisks) {
		long startTime = System.nanoTime();
		Stack<Integer> firstRod = new Stack<Integer>();
		Stack<Integer> secondRod = new Stack<Integer>();
		Stack<Integer> thirdRod = new Stack<Integer>();
		for (int i = numberOfDisks; i > 0; i--) {
			firstRod.push(i);
		}
		System.out.println(recursiveSolver(firstRod, secondRod, thirdRod, numberOfDisks));
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);

	}


	public static Stack<Integer> recursiveSolver(Stack<Integer> firstRod, Stack<Integer> secondRod,
			Stack<Integer> thirdRod, int numberOfDisks) {
		if (numberOfDisks == 1) {
			if (firstRod.contains(1)) {
				thirdRod.push(firstRod.pop());
			} else {
				thirdRod.push(secondRod.pop());
			}
		} else {
			recursiveSolver(firstRod, thirdRod, secondRod, numberOfDisks - 1);
			if (firstRod.contains(numberOfDisks)) {
				thirdRod.push(firstRod.pop());
			} else {
				thirdRod.push(secondRod.pop());
			}
			recursiveSolver(secondRod, firstRod, thirdRod, numberOfDisks - 1);
		}
		return thirdRod;
	}

	public static void main(String args[]) {
		solveHanowiTower(100);

	}

}
