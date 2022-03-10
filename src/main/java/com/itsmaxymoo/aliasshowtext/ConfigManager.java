package com.itsmaxymoo.aliasshowtext;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ConfigManager {
	private static JavaPlugin pluginInstance;
	private static HashMap<String, ArgString> mapArgStrings = new HashMap<>();

	public static void initialize(JavaPlugin plugin) {
		pluginInstance = plugin;

		pluginInstance.saveDefaultConfig();

		load();
	}

	public static void reload() {
		pluginInstance.reloadConfig();

		load();
	}

	private static void load() {
		// Load strings
		int stringsLoaded = 0;
		String stringMapName = "strings";

		try {
			for (String k : pluginInstance.getConfig().getConfigurationSection(stringMapName).getKeys(false)) {
				mapArgStrings.put(k, new ArgString(pluginInstance.getConfig().getString(stringMapName + "." + k)));
				stringsLoaded++;
			}
		} catch (Exception e) {
		}

		pluginInstance.getLogger().info("Loaded " + stringsLoaded + " strings.");
	}

	public static ArgString getArgString(String s) {
		return mapArgStrings.get(s);
	}
}
