package dp;
import java.util.HashMap;

public class InterLeavedString {
	public static void main(String[] args) {
		String A = "eZCHXr0CgsB4O3TCDlitYI7kH38rEElI";
		String B = "UhSQsB6CWAHE6zzphz5BIAHqSWIY24D";
		String C = "eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D";
		//System.out.println("hello : " + new Solution().isInterleave(A, B, C));
		check(A, B, C);
	}

	public static void check(String input1, String input2, String output) {
		HashMap<Character, Integer> dataMap = new HashMap<>();
		System.out.println(dataMap.size());

		for (char ch : input1.toCharArray()) {
			if (dataMap.containsKey(ch)) {
				int count = dataMap.get(ch);
				dataMap.put(ch, count + 1);
			} else {
				dataMap.put(ch, 1);
			}
		}
		System.out.println(dataMap.size());

		for (char ch : input2.toCharArray()) {
			if (dataMap.containsKey(ch)) {
				int count = dataMap.get(ch);
				dataMap.put(ch, count + 1);
			} else {
				dataMap.put(ch, 1);
			}
		}
		System.out.println(dataMap.size());


		for (char ch : output.toCharArray()) {
			if (dataMap.containsKey(ch)) {
				int count = dataMap.get(ch);
				if (count == 1) {
					dataMap.remove(ch);
				} else {
					dataMap.put(ch, count - 1);
				}
			} else {
				System.out.println("Wrong Input");
			}
		}

		System.out.println(dataMap.size());
	}

	public int isInterleave(String input1, String input2, String output) {
		if ((input1.length() + input2.length()) != output.length()) {
			return 0;
		}
		if (isStringFound(output, input1) && isStringFound(output, input2)) {
			return 1;
		}
		return 0;

	}

	private boolean isStringFound(String output, String input) {
		int inputIndex = 0;
		for (int i = 0, size = output.length(); i < size; i++) {
			if (input.charAt(inputIndex) == output.charAt(i)) {
				if (inputIndex == input.length() - 1) {
					return true;
				}
				inputIndex++;
			}

		}
		return false;
	}

}
