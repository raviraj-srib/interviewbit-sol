package dp;
/*
 * https://www.interviewbit.com/problems/regular-expression-match/
 */
public class RegexComplete {

	public static void main(String[] args) {
		String data1 = "abcdefghijk";
		String pattern1 = "a*g?i";

		String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String B = "a**************************************************************************************";
		A = "bbbcbcb";
		B = "**cb";
		A = "bacb";
		B = "b**c*?*";
		A = "acbbcacbcbac";
		B = "a*?c";

		System.out.println("Data : " + A + " Pattern : " + B + " Matched :" + isMatch(A, B));

		// System.out.println("Data : " + data1 + " Pattern : " + pattern1 + " Matched
		// :" + isMatch(data1, pattern1));
	}

	public static int isMatch(final String data, final String pattern) {
		int patternIndex = 0;
		boolean isCharStarFound = false;
		int lastCharStarIndex = 0;
		for (int i = 0, size = data.length(); i < size; i++) {
			char pa = pattern.charAt(patternIndex);
			switch (pa) {
			case '?':
				patternIndex++;
				break;
			case '*':
				i--;
				patternIndex++;
				while (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
					patternIndex++;
				}
				lastCharStarIndex = patternIndex;
				isCharStarFound = true;
				break;

			default:
				if (data.charAt(i) == pa) {
					patternIndex++;
				} else if (!isCharStarFound) {
					return 0;
				} else {
					patternIndex = lastCharStarIndex;
				}
			}

			if (patternIndex == pattern.length()) {
				// Compeleted the match
				if (i + 1 == data.length()) {
					return 1;
				} else {
					if (!isCharStarFound) {
						return 0;
					} else {
						if (pattern.charAt(patternIndex - 1) == '*') {
							return 1;
						}
						patternIndex = lastCharStarIndex;
					}
				}
			}
		}

		// Check for end **
		if (patternIndex < pattern.length()) {
			for (int i = patternIndex; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return 0;
				}
			}
			return 1;
		}
		return 0;

	}

}
