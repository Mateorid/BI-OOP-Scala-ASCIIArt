package ASCIIArtApp.UI.InputHandlers

import ASCIIArtApp.Commands.Filters.{
  BrightnessFilterCommand,
  InvertFilterCommand,
  RotateFilterCommand
}
import ASCIIArtApp.Commands.Input.{
  PathInputCommand,
  RandomInputCommand,
  URLInputCommand
}
import ASCIIArtApp.Commands.Output.{ConsoleOutputCommand, FileOutputCommand}
import ASCIIArtApp.Commands._
import ASCIIArtApp.Exporters.{FileOutputExporter, StdOutputExporter}
import ASCIIArtApp.Loaders.{
  PathRGBImageLoader,
  RandomRGBImageLoader,
  URLRGBImageLoader
}
import ASCIIArtApp.UI.Controller.GSFiltersImageController
import ASCIIArtApp.Commands._
import ASCIIArtApp.ImageFilters.{
  BrightnessFilter,
  InvertImageFilter,
  RotateImageFilter
}

import java.io.File
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

class ConsoleInputHandler(controller: GSFiltersImageController)
    extends InputHandler[Array[String]] {

  def handleInput(commands: Array[String]): Unit = {
    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)

    controller.executeCommands()
    controller.export()
  }

  private def parseCommands(commands: Array[String]): Array[String] = {
    val parsed = new ArrayBuffer[String]
    var cmd = new String
    var lastWasArg = false

    for (i <- commands)
      if (i.startsWith("--")) {
        if (lastWasArg) {
          parsed += cmd
          cmd = ""
        }
        cmd = i
        lastWasArg = true
      } else {
        cmd += " " + i
        parsed += cmd
        cmd = ""
        lastWasArg = false
      }
    if (cmd != "")
      parsed += cmd

    parsed.toArray
  }

  private def processCommand(command: String): Unit = {
    val cmd = RegExCommand(command.r)
    cmd match {
      case PathInputCommand(_)        => PathInputCommand(controller).run(command)
      case URLInputCommand(_)         => URLInputCommand(controller).run(command)
      case RandomInputCommand(_)      => RandomInputCommand(controller).run(command)
      case ConsoleOutputCommand(_)    => ConsoleOutputCommand(controller).run(command)
      case FileOutputCommand(_)       => FileOutputCommand(controller).run(command)
      case BrightnessFilterCommand(_) => BrightnessFilterCommand(controller).run(command)
      case InvertFilterCommand(_)     => InvertFilterCommand(controller).run(command)
      case RotateFilterCommand(_)     => RotateFilterCommand(controller).run(command)
      case _ => throw new IllegalArgumentException("Unknown command!") //todo print available commands?
    }
  }

  //todo change this to the labs version - regex matcher etc
//  private def processCommand(command: String): Unit = {
//    //Input file
//    if (command.startsWith("--image-url")) {
//      controller.setInput(new URLRGBImageLoader(command.substring(8)))
//      return
//    } else if (command.startsWith("--image-random")) { //todo RandomGenerator taking 2 argument height X width
//      controller.setInput(RandomRGBImageLoader)
//      return
//    } else if (command.startsWith("--image")) {
//      //todo check for filetype we cant handle .png for example
//      controller.setInput(new PathRGBImageLoader(command.substring(8)))
//      return
//    }
//    //Output file
//    if (command.startsWith("--output-file")) {
//      val file = new File(command.substring(14))
//      controller.setOutput(new FileOutputExporter(file))
//      return
//    } else if (command == "--output-console") {
//      controller.setOutput(StdOutputExporter)
//      return
//    }
//    //Filters
//    if (command.startsWith("--rotate")) {
//      //todo try catch this
//      val degrees: Int = command.substring(9).toInt
//      if (degrees % 90 != 0)
//        throw new Exception(
//          "Incorrect command format, --rotation supports only 90 degrees rotations")
//      controller.addFilter(new RotateImageFilter(degrees))
//      return
//    } else if (command.startsWith("--brightness")) {
//      //todo try catch this
//      val x: Int = command.substring(13).toInt
//      controller.addFilter(new BrightnessFilter(x))
//      return
//    }
//    command match {
//      case "--invert" =>
//        controller.addFilter(new InvertImageFilter)
//      case _ => throw new Exception("Incorrect command, use \"help\" for help")
//    }
//  }

}
