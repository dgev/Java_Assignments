package example;

public class FibonacciNumber {
	
	// Recursive solution

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fib = fibonacci(n - 1) + fibonacci(n - 2);
		return fib;
	}

	public static void recursiveFibonacci(int n) {
		int i = 0;
		String series = "";
		while (i != n) {
			series += fibonacci(i) + " ";
			i++;
		}		
		System.out.println(series);		
	}
	
	// Iterative solution
	
	public static void iterativeFibonacci(int n) {
	    if (n == 0 || n == 1) {
	    	System.out.println(n);
	    } else {
	        int previous1 = 0;
	        int previous2 = 1;
	        String fibonacci = previous1 + ", " + previous2 + ", ";
	        for (int i = 2; i < n; i++) {
	        	previous2 += previous1;
	            previous1 = previous2 - previous1;
	            fibonacci += previous2 + ", ";
	        }
	        System.out.println(fibonacci);
	    }
	}
	
	public static void main(String args[]) {
		recursiveFibonacci(10);
		iterativeFibonacci(10);
	}

}
