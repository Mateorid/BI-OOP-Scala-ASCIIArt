package ASCIIArtApp.UI

import ASCIIArtApp.AppExecutionLogic.ConfigExecutor
import ASCIIArtApp.Commands.Filters.{BrightnessFilterCmd, InvertFilterCmd, RotateFilterCmd}
import ASCIIArtApp.Commands.Input.{PathInputCmd, RandomInputCmd, URLInputCmd}
import ASCIIArtApp.Commands.Output.{ConsoleOutputCmd, FileOutputCmd}
import ASCIIArtApp.Config.Config

/**
 * Handles user input
 *
 * @param config   config where user input will be set
 * @param executor config executor that will be called to execute the user inputs
 */
class ConsoleInputHandler(val config: Config, val executor: ConfigExecutor) extends InputHandler[Seq[String]] {

  /**
   * Handles the provided commands
   *
   * @param commands commands to be handled
   */
  def handleInput(commands: Seq[String]): Unit = {
    if (commands.isEmpty)
      throw new IllegalArgumentException("--ERROR--\nYou need to provide input & output!")

    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)

    executor.run(config)
  }

  /**
   * Parses the arguments provided by merging them until "--" is found
   *
   * @param args commands to be parsed
   * @return parsed commands
   */
  private def parseCommands(args: Seq[String]): Seq[String] = {
    var parsed = Seq.empty[String]
    var cmd: String = null

    for (i <- args)
      if (i.startsWith("--")) {
        if (cmd != null)
          parsed = parsed :+ cmd
        cmd = i
      } else
        cmd += " " + i

    parsed = parsed :+ cmd
    parsed
  }

  /**
   * Calls commands based on given command
   *
   * @param command command to be called
   */
  private def processCommand(command: String): Unit =
    command match {
      case PathInputCmd.pattern(x) => PathInputCmd(x, config).run()
      case URLInputCmd.pattern(x) => URLInputCmd(x, config).run()
      case RandomInputCmd.pattern(x, y) =>
        RandomInputCmd(x.toInt, y.toInt, config).run()
      case ConsoleOutputCmd.pattern() => ConsoleOutputCmd(config).run()
      case FileOutputCmd.pattern(x) => FileOutputCmd(x, config).run()
      case BrightnessFilterCmd.pattern(x) =>
        BrightnessFilterCmd(x.toInt, config).run()
      case InvertFilterCmd.pattern() => InvertFilterCmd(config).run()
      case RotateFilterCmd.pattern(x) => RotateFilterCmd(x.toInt, config).run()
      case _ =>
        throw new IllegalArgumentException(
          "Unknown command or wrong command arguments!")
    }
}
