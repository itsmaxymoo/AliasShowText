package com.itsmaxymoo.aliasshowtext;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandShowText implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length <= 0) {
			return false;
		}

		StringBuilder sb = new StringBuilder();

		for (String token : args) {
			sb.append(token).append(" ");
		}

		sender.sendMessage(sb.toString());

		return true;
	}
}
