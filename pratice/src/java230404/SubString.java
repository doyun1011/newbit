package java230404;

public class SubString {
	static String str = "abcdefgsdfqqqaasc";

	public static void main(String[] args) {
		String str1 = subString1(1, 6);
		String str2 = subString(5);
		System.out.println(str1);
		System.out.println(str2);
		String s1 = "a";

		int result = indexOf1(s1);
		int result2 = lastIndexOf(s1);
		System.out.println(result);
		System.out.println(result2);
	}

	public static String subString1(int startIdx, int endIdx) {
		char[] tmp = new char[endIdx - startIdx];

		int cnt = 0;
		for (int i = startIdx; i < endIdx; i++) {

			tmp[cnt] = str.charAt(i);
			cnt++;
		}
		String str2 = new String(tmp);
		return str2;
	}

	public static String subString3(int startIdx, int endIdx) {
		char[] tmp = new char[endIdx - startIdx];
		char[] tmp2 = new char[endIdx - startIdx];

		int cnt = 0;
		int cnt2 = 0;
		for (int i = str.length() - startIdx; i < i - endIdx; i--) {

			tmp[cnt] = str.charAt(i);
			cnt++;
		}
		for (int i = tmp.length - 1; i > 0; i--) {
			tmp2[cnt] = tmp[i];
			cnt++;
		}
		String str2 = new String(tmp2);
		return str2;
	}

	public static String subString(int startIdx) {
		char[] tmp = new char[str.length()];

		int cnt = 0;
		for (int i = startIdx; i < str.length(); i++) {
			tmp[cnt] = str.charAt(i);
			cnt++;
		}
		String str2 = new String(tmp);
		return str2;
	}

	public static int indexOf1(String s) {
		int length = s.length();
		char[] tmp = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (str.length() == length + i) {
				return -1;
			}
			if (s.equals(subString1(i, length + i))) {
				return i;
			}
		}
		return -1;
	}

	public static int lastIndexOf(String s) {
		int length = s.length();
		char[] tmp = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (str.length() == length + i) {
				return -1;
			}
			if (s.equals(subString3(i, length + i))) {
				return i;
			}
		}
		return -1;
	}
}
