package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPlayerY extends TextFunction {
	@Override
	protected int getNumberOfArguments() {
		return 0;
	}

	@Override
	protected String getFunctionName() {
		return "playerY";
	}

	@Override
	public String compute(CommandSender sender, String[] args) throws InvalidSenderTypeException {
		if (!(sender instanceof Player)) {
			throw new InvalidSenderTypeException("You must be a player!");
		}

		Player player = (Player) sender;

		return "" + player.getLocation().getBlockY();
	}
}
