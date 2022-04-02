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

### Arguments

Arguments are only supported by `_showstring` and use a `{{ argument number }}` format. For example:

```yaml
strings:
  argument-test: "String name: {{ 0 }}, First argument: {{ 1 }}"
```

...can be called using the command `_showstring argument-test Apple`,
which would display `String name: argument-test, First argument: Apple` to the user.

Some things to note:

* The 0th argument is always the string name
* Arguments are processed before functions
* Arguments follow the format `{{ n }}` where `n` is the number argument you wish to use
* If you try to access an argument that does not exist, the `{{ n }}` tag will **not** be replaced

### Functions

Functions are only supported by `_showstring` and use a `{% func_name arg1, arg2, etc... %}` format. For example:

```yaml
strings:
  end: "End portal entrance: 1140, 117, 1808 ({% distance3d 1140 117 1801 %} blocks away)"
```

...will tell the user how far away they are from the server's end portal entrance.
**Please remember,** arguments are processed before functions!
This allows you to pass argument values as function parameters.

#### Function List

| **Function** | **Arguments** | **Usage**                                                                                                   |
|--------------|---------------|-------------------------------------------------------------------------------------------------------------|
| `distance3d` | num, num, num | Returns the user's distance from the specified position. Player only.                                       |
| `distance2d` | num, num      | Returns the user's distance from the specified position, only considering X and Z coordinates. Player only. |
| `playerX`    |               | Returns the user's X position. Player only.                                                                 |
| `playerY`    |               | Returns the user's Y position. Player only.                                                                 |
| `playerZ`    |               | Returns the user's Z position. Player only.                                                                 |

## To-Do

* verbosity based off of op/permission
* Support for special cases (ex: joining the server)
