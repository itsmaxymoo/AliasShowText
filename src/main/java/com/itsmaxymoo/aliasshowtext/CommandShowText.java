package com.itsmaxymoo.aliasshowtext;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.units.qual.A;

public class CommandShowText implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length <= 0) {
			return false;
		}

		// Create string from arguments

		StringBuilder sb = new StringBuilder();

		/* for (String token : args) {
			sb.append(token).append(" ");
		}

		// Create ArgString to process potential function calls
		ArgString argString = new ArgString(sb.toString());

		sender.sendMessage(argString.getFormatted(sender, new String[]{})); */

		sender.sendMessage(sb.toString());

		return true;
	}
}
