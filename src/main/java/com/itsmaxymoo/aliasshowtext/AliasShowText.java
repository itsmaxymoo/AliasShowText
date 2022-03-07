package com.itsmaxymoo.aliasshowtext;

import org.bukkit.plugin.java.JavaPlugin;

public final class AliasShowText extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic

		getCommand("_showtext").setExecutor(new CommandShowText());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
