package com.itsmaxymoo.aliasshowtext;

import com.itsmaxymoo.aliasshowtext.command.CommandAdmin;
import com.itsmaxymoo.aliasshowtext.command.CommandShowString;
import com.itsmaxymoo.aliasshowtext.command.CommandShowText;
import org.bukkit.plugin.java.JavaPlugin;

public final class AliasShowText extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic

		// Plugin configuration
		ConfigManager.initialize(this);

		// Register commands
		getCommand("aliasshowtext").setExecutor(new CommandAdmin());
		getCommand("_showtext").setExecutor(new CommandShowText());
		getCommand("_showstring").setExecutor(new CommandShowString());

		// Register listeners
		getServer().getPluginManager()
				.registerEvents(new com.itsmaxymoo.aliasshowtext.events.OnPlayerJoin(this), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
