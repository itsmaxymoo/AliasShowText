package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetDistance3D extends TextFunction {
	@Override
	public short getNumberOfArguments() {
		return 3;
	}

	@Override
	public String getFunctionName() {
		return "distance3d";
	}

	@Override
	public String compute(CommandSender sender, String[] args) throws InvalidSenderTypeException {
		if (!(sender instanceof Player)) {
			throw new InvalidSenderTypeException("You must be a player!");
		}

		Player player = (Player) sender;

		int tx, ty, tz;

		try {
			tx = Integer.parseInt(args[1]);
			ty = Integer.parseInt(args[2]);
			tz = Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			return "ERROR";
		}

		int px = player.getLocation().getBlockX();
		int py = player.getLocation().getBlockY();
		int pz = player.getLocation().getBlockZ();

		return "" + Math.round(
				Math.sqrt(Math.pow(tx - px, 2) + Math.pow(ty - py, 2) + Math.pow(tz - pz, 2))
		);
	}
}
