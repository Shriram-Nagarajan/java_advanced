package util;

public class Utils {
	public static String stringify(String[] arrayOfStr) {
		StringBuilder builder = new StringBuilder();
		for(String str: arrayOfStr) {
			builder.append(str).append(" ");
		}
		return builder.toString();
	}
}
