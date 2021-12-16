package ASCIIArtApp.UI

import ASCIIArtApp.Commands.Filters.{BrightnessFilterCmd, InvertFilterCmd, RotateFilterCmd}
import ASCIIArtApp.Commands.Input.{PathInputCmd, RandomInputCmd, URLInputCmd}
import ASCIIArtApp.Commands.Output.{ConsoleOutputCmd, FileOutputCmd}
import ASCIIArtApp.Config.Config
import ASCIIArtApp.ImageTransformation

import scala.collection.mutable.ArrayBuffer

object ConsoleInputHandler extends InputHandler[Array[String]] {
  val config = new Config

  def handleInput(commands: Array[String]): Unit = {
    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)

    ImageTransformation.run(config)
  }

  private def parseCommands(args: Array[String]): Array[String] = {
    val parsed = new ArrayBuffer[String]
    var cmd: String = null

    for (i <- args)
      if (i.startsWith("--")) {
        if (cmd != null)
          parsed += cmd
        cmd = i
      } else
        cmd += " " + i

    parsed += cmd
    parsed.toArray
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
          "Unknown command or wrong arguments!")
    }
}
