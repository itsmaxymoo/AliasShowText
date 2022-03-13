package com.itsmaxymoo.aliasshowtext.textfunction;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public class GetDistance3D extends TextFunction {
	@Override
	public Pattern getRegex() {
		return Pattern.compile("(distance3d) +-?[0-9]+ +-?[0-9]+ +-?[0-9]+");
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
