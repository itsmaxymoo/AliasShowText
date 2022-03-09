package com.itsmaxymoo.aliasshowtext;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReloadPluginConfig implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		ConfigManager.reload();

		sender.sendMessage("Strings reloaded successfully");

		return true;
	}
}
