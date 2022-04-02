package com.itsmaxymoo.aliasshowtext.events;

import com.itsmaxymoo.aliasshowtext.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OnPlayerJoin implements Listener {
	private final String MAGIC_STRING_NAME = "_onjoin";
	private final JavaPlugin server;

	public OnPlayerJoin(JavaPlugin server) {
		this.server = server;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (ConfigManager.getLoadedStringNames().contains(MAGIC_STRING_NAME)) {
			Bukkit.getScheduler().runTaskLater(server, new Runnable() {
				@Override
				public void run() {
					e.getPlayer().sendMessage(
							ConfigManager.getArgString(MAGIC_STRING_NAME)
									.getFormatted(e.getPlayer(), new String[]{MAGIC_STRING_NAME})
					);
				}
			}, 2L);
		}
	}
}
