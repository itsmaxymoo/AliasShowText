package com.itsmaxymoo.aliasshowtext.command;

import com.itsmaxymoo.aliasshowtext.ArgString;
import com.itsmaxymoo.aliasshowtext.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandShowString implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			ArgString aString = ConfigManager.getArgString(args[0]);

			if (aString != null) {
				sender.sendMessage(aString.getFormatted(sender, args));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
