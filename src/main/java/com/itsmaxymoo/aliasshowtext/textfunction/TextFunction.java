package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;

import java.util.regex.Pattern;

public abstract class TextFunction {
	private final Pattern innerPattern, outerPattern;

	public TextFunction() {
		// Inner regex
		StringBuilder innerRegexStringBuilder = new StringBuilder();
		innerRegexStringBuilder.append("(")
				.append(getFunctionName())
				.append(")");

		for (int i = 0; i < getNumberOfArguments(); i++) {
			innerRegexStringBuilder.append(" +-?[\\x21-\\x7E]+");
		}

		innerPattern = Pattern.compile(innerRegexStringBuilder.toString());

		// Outer regex
		outerPattern = Pattern.compile("\\{% *" + innerRegexStringBuilder + " *%}");
	}

	public final Pattern getInnerPattern() {
		return innerPattern;
	}

	public final Pattern getOuterPattern() {
		return outerPattern;
	}

	protected abstract int getNumberOfArguments();

	protected abstract String getFunctionName();

	public abstract String compute(CommandSender sender, String[] args) throws InvalidSenderTypeException;
}
