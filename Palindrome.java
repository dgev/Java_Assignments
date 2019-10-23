
public class Palindrome {

	public static boolean isPalindrome(String str) {
		String[] word = str.split(" ");
		StringBuilder line = new StringBuilder();
		
		for(String item : word) {
			line.append(item);
		}
		
		char[] words = line.toString().split(" ")[0].toCharArray();
		line = new StringBuilder();
		
		for (char ch : words) {
			if (Character.isLetter(ch)) {
				line.append(ch);
			}
		}
		
		return (line.toString()).equalsIgnoreCase(line.reverse().toString());
	}

}
