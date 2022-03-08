# Alias Show Text

A Spigot plugin to allow commands.yml aliases to show text to the user.
This can be used to make basic custom commands!

## Installation

Grab the latest jar file from the releases section and place it in your plugins folder!

While this plugin has only been tested on 1.18, it should work on most earlier versions as well as future.

## Usage

AliasShowText is used entirely in the `commands.yml` file.
Simply use the `_showtext` command under an alias, and all text after will be displayed to the user.
For example, the following creates a command `/discord` that gives the user the URL of the Discord server:

```yaml
aliases:
  discord:
  - '_showtext Discord server: https://discord.gg/minecraft'
```

Of course, `_showtext` supports [standard Minecraft formatting codes](https://minecraft.fandom.com/wiki/Formatting_codes).

## To-Do

* Support for storing text strings in a seperate file
	* Allow server operator to reload strings at runtime
	* Allow text strings to support arguments
* Support for special text functions
