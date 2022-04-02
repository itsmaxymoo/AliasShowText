package com.itsmaxymoo.aliasshowtext;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandAdmin implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			switch (args[0].toLowerCase()) {
				case "reload":
					ConfigManager.reload();
					sender.sendMessage("Strings reloaded successfully");
					return true;

				case "list":
					sender.sendMessage("The following strings are loaded:");

					for (String s : ConfigManager.getLoadedStringNames()) {
						sender.sendMessage(s);
					}
					return true;
			}
		}

		return false;
	}
}
