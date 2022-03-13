package com.itsmaxymoo.aliasshowtext;

import com.itsmaxymoo.aliasshowtext.textfunction.GetDistance2D;
import com.itsmaxymoo.aliasshowtext.textfunction.GetDistance3D;
import com.itsmaxymoo.aliasshowtext.textfunction.InvalidSenderTypeException;
import com.itsmaxymoo.aliasshowtext.textfunction.TextFunction;
import org.bukkit.command.CommandSender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgString {
	private String rawString;

	public ArgString(String s) {
		rawString = s;
	}

	public String getFormatted(CommandSender sender, String[] args) {
		String formattedString = rawString;

		// *** Process args first

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

		// *** Process functions
		TextFunction[] textFunctions = {
				new GetDistance3D(),
				new GetDistance2D()
		};
		for (TextFunction tf : textFunctions) {
			// Get instances of command (outer regex)
			Pattern outerRegex = Pattern.compile("\\{% *" + tf.getRegex() + " *%}");
			Matcher matcherCommandInstances = outerRegex.matcher(formattedString);
			while (matcherCommandInstances.find()) {
				String match = matcherCommandInstances.group();
				// Get inner regex
				Matcher matcherInner = tf.getRegex().matcher(match);
				matcherInner.find();

				String innerMatch = matcherInner.group();

				// Set result
				String result = "";
				try {
					result = tf.compute(sender, innerMatch.trim().split("\\s+"));
				} catch (InvalidSenderTypeException e) {
					return "You must be a player!";
				}

				formattedString = formattedString.replace(match, result);
			}
		}

		return formattedString;
	}

	@Override
	public String toString() {
		return rawString;
	}
}
