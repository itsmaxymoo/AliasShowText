package com.itsmaxymoo.aliasshowtext;

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
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
