package com.itsmaxymoo.aliasshowtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgString {
	private String rawString;

	public ArgString(String s) {
		rawString = s;
	}

	public String getFormatted(String[] args) {
		String formattedString = rawString;

		// Setup regex
		Pattern patternArg = Pattern.compile("(\\{\\{ *[0-9]+ *}})");
		Pattern patternArgNumber = Pattern.compile("[0-9]+");

		// Remember, args[0] will be the string name
		// Find matches and loop through
		Matcher matcherArgs = patternArg.matcher(rawString);
		while (matcherArgs.find()) {
			// Get argument number from {{ arg match # }}
			String match = matcherArgs.group();
			Matcher matcherArgNum = patternArgNumber.matcher(match);
			int argNum = -1;
			if (matcherArgNum.find()) {
				argNum = Integer.parseInt(matcherArgNum.group());
			}

			// Ensure arg number was passed to the _showstring call
			if (argNum >= 0 && argNum < args.length) {
				// Replace with argument
				formattedString = formattedString.replace(match, args[argNum]);
			}
		}

		return formattedString;
	}

	@Override
	public String toString() {
		return rawString;
	}
}
