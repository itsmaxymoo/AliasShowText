package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetDistance2D extends TextFunction {
	@Override
	protected int getNumberOfArguments() {
		return 2;
	}

	@Override
	protected String getFunctionName() {
		return "distance2d";
	}

	@Override
	public String compute(CommandSender sender, String[] args) throws InvalidSenderTypeException {
		if (!(sender instanceof Player)) {
			throw new InvalidSenderTypeException("You must be a player!");
		}

		Player player = (Player) sender;

		int tx, tz;

		try {
			tx = Integer.parseInt(args[1]);
			tz = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			return "ERROR";
		}

		int px = player.getLocation().getBlockX();
		int pz = player.getLocation().getBlockZ();

		return "" + Math.round(
				Math.sqrt(Math.pow(tx - px, 2) + Math.pow(tz - pz, 2))
		);
	}
}
