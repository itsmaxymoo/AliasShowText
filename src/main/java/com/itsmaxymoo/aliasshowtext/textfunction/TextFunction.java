package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;

import java.util.regex.Pattern;

public abstract class TextFunction {
	public abstract short getNumberOfArguments();

	public abstract String getFunctionName();

	public abstract String compute(CommandSender sender, String[] args) throws InvalidSenderTypeException;
}
