package ASCIIArtApp.UI

import ASCIIArtApp.Commands.Filters.{BrightnessFilterCmd, InvertFilterCmd, RotateFilterCmd}
import ASCIIArtApp.Commands.Input.{PathInputCmd, RandomInputCmd, URLInputCmd}
import ASCIIArtApp.Commands.Output.{ConsoleOutputCmd, FileOutputCmd}
import ASCIIArtApp.Config.Config
import ASCIIArtApp.ImageTransformation


class ConsoleInputHandler(config: Config) extends InputHandler[Seq[String]] {

  def handleInput(commands: Seq[String]): Unit = {
    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)

    ImageTransformation.run(config)
  }

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
