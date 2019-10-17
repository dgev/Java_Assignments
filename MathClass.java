package homework_2;

import java.lang.Math;
import java.util.Scanner;

public class MathClass {

//	Problem 1

	public static void oddOrEven(int number) {
		System.out.println((number % 2 == 0 ? "even" : "odd"));
	}

//	Problem 2

	public static void isDivisible(int num1, int num2) {

		System.out.println((num1 % num2 == 0 || num2 % num1 == 0) ? 1 : 0);
	}

//	Problem 3

	public static void sum(int n) {
		System.out.println(n + "" + 2 * n + 3 * n);
	}

//	Problem 4

	public static void lastDigit(int n) {
		System.out.println((n % 10 != 0 && n > 10) ? n % 10 + "" + (n - n % 10) / 10 : n);
	}

//	Problem 5

	public static void average(double num1, double num2, double num3, double num4, double num5) {
		System.out.println((num1 + num2 + num3 + num4 + num5) / 5);
	}

//	Problem 6

	public static void sort(int num1, int num2, int num3) {
		if (num1 < num2) {
			if (num2 < num3) {
				System.out.println(num1 + ", " + num2 + ", " + num3);
			} else if (num1 < num3) {
				System.out.println(num1 + ", " + num3 + ", " + num2);
			} else {
				System.out.println(num3 + ", " + num1 + ", " + num2);
			}
		} else if (num2 < num1) {
			if (num1 < num3) {
				System.out.println(num2 + ", " + num1 + ", " + num3);
			} else if (num2 > num3) {
				System.out.println(num3 + ", " + num2 + ", " + num1);
			} else {
				System.out.println(num2 + ", " + num3 + ", " + num1);
			}
		}
	}

//	Problem 7

	public static void sign(int num1, int num2, int num3) {
		if (num1 == 0 || num2 == 0 || num3 == 0) {
			System.out.println("unsigned");
		} else {
			int count = 0;
			if (num1 < 0)
				count++;
			if (num2 < 0)
				count++;
			if (num3 < 0)
				count++;
			if (count % 2 == 0) {
				System.out.println("+");
			} else {
				System.out.println('-');
			}
		}
	}

//	Problem 8

	public static void quadratic(int a, int b, int c) {
		if (a == 0) {
			System.out.println("Enter valid constants");
		} else {
			double discriminant = b * b - 4 * a * c;
			if (discriminant < 0) {
				System.out.println("Solution does not exist");
			} else if (discriminant == 0) {
				System.out.println("Solution is " + (-1 * b) / (2 * a));
			} else {
				System.out.println("Solutions are " + (-1 * b - Math.sqrt(discriminant)) / (2 * a) + " and "
						+ (-1 * b + Math.sqrt(discriminant)) / (2 * a));
			}
		}
	}

//	Problem 9

	public static void func() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int i = 0;
		int j = 0;

		if ((n % 2 == 0) && n / 10 != 0) {
			i += 1;
			System.out.println(i);
		}

		if (n % 3 == 0 && n % 10 == 1) {
			j += 1;
			System.out.println(j);
		}
	}

//	Problem 10

	public static void contains(int digit, int num) {
		while (num > 0) {
			if (digit == num % 10) {
				System.out.println("Yes");
				break;
			}
			num /= 10;
		}
		if (num == 0) {
			System.out.println("No");
		}
	}

//	 Problem 11 WRONG ANSWER

	public static void reverse(int num) {
	    if (num > 10) {
	        int lastDigit = (int) (num % 10);
	        num = num / 10;
	        int firstDigit = (int) num;
	        int count = 0;
	        while (firstDigit > 10) {
	            firstDigit /= 10;
	            count++;
	        }
	        num = (int) ((lastDigit * Math.pow(10, count) + ((int) num - firstDigit * Math.pow(10, count))) * 10 + firstDigit);
	    }
	    System.out.println(num);
	}

//	   Problem 12

	public static void area() {
		System.out.println("Specify the figure!");
		Scanner in = new Scanner(System.in);
		String figure = in.nextLine(); 
		System.out.println("Enter first meausurement");
		int a = in.nextInt();
		System.out.println("Enter second meausurement");
		int b = in.nextInt();
		in.close();
		if (a > 0 && b > 0) {
			int area = a * b;
			if (figure.contentEquals("triangle")) {
				System.out.println(area / 2);
			} else if (figure.contentEquals("rectangle")) {
				System.out.println(area);
			}
		} else {
			System.out.println("Please enter only positives");
		}
	}

//	  Problem 13

	public static void difference(int num) {
		int max, min;
		max = min = num % 10;
		while (num > 10) {
			num = num / 10;
			if (min > num % 10) {
				min = num % 10;
			}
			if (max < num % 10) {
				max = num % 10;
			}
		}
		System.out.println(max - min);
	}

	public static void main(String[] args) {

//		oddOrEven(4);		
//		isDivisible(7,21);
//		sum(100);
//		lastDigit(8);		
//		average(7, 52, -23, 9, -81);
//		sort(-23, -456, 0);
//		sign(4, 19, -2 );
//		quadratic(1,2,1);
//		func();
//		contains(8, 45689);
//		reverse(13);
//		difference(152);
//		area();

	}
}
