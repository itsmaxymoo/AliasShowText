# Alias Show Text

A Spigot plugin to allow commands.yml aliases to show text to the user.
This can be used to make basic custom commands!

## Installation

Grab the latest jar file from the releases section and place it in your plugins folder!

While this plugin has only been tested on 1.18, it should work on earlier versions as well as future.

## Usage

### Simple Aliases

Simply use the `_showtext` command under an alias, and all text after will be displayed to the user.
For example, the following creates a command `/discord` that gives the user the URL of the Discord server:

```yaml
aliases:
  discord:
  - '_showtext Discord server: https://discord.gg/minecraft'
```

Of course, `_showtext` supports [standard Minecraft formatting codes](https://minecraft.fandom.com/wiki/Formatting_codes).

### Advanced Strings

The `_showstring` command will display to the user a string defined in the plugin's `config.yml` under the `strings` section.
The config file can be reloaded at any time using the `aliasshowtext-reload` command (OP only or permission `aliasshowtext.reload`).
Advanced strings have the advantage of supporting arguments. An example string in config.yml:

```yaml
strings:
  argument-test: "String name: {{ 0 }}, First argument: {{ 1 }}"
```

...can be called using the command `_showstring argument-test Apple`,
which would display `String name: argument-test, First argument: Apple` to the user.

Some things to note:

* The 0th argument is always the string name
* Arguments follow the format `{{ n }}` where `n` is the number argument you wish to use
* If you try to access an argument that does not exist, the `{{ n }}` tag will **not** be replaced.

## To-Do

* ~~Support for storing text strings in a seperate file~~
	* ~~Allow server operator to reload strings at runtime~~
	* ~~Allow text strings to support arguments~~
* Support for special text functions
* Support for special cases (ex: joining the server)
