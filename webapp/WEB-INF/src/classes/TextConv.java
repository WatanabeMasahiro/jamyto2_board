package classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextConv {
	public static String beforeHtml(String str) {
		return str.replaceAll("&",  "&amp;")
				.replaceAll("<",  "&lt;")
				.replaceAll(">",  "&gt;")
				.replaceAll("\"",  "&quot;")
				.replaceAll("'",  "&#39;")
				.replaceAll(" ", "&nbsp;")
				.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;")
				.replaceAll("\n", "<br>");
	}
	
		public static String beforehtmlAddNewline(String str) {
			return str.replaceAll("&",  "&amp;")
					.replaceAll("<",  "&lt;")
					.replaceAll(">",  "&gt;")
					.replaceAll("\"",  "&quot;")
					.replaceAll("'",  "&#39;")
					.replaceAll(" ", "&nbsp;")
					.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;")
//					.replaceAll("\n", "<br>")
					.replaceAll("[\r\n]", " ");
	}

	public static String beforeSql(String str) {
		return str.replaceAll("\\\\",  "\\\\\\\\")
				.replaceAll("\"",  "\\\"")
				.replaceAll("'",  "\\\\'")
				.replaceAll("%",  "\\%")
				.replaceAll("_",  "\\_");
	}
	
	public static String embedLink(String str) {
		String strPattern = "(http://|https://)[\\w\\[\\]\\-:/?#@!$&'()*+,;=.~%]+";
		Pattern pattern = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll("<a href='$0'>$0</a>");
	}
}
