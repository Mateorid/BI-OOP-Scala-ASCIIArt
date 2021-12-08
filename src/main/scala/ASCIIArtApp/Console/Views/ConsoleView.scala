package ASCIIArtApp.Console.Views

import ASCIIArtApp.Console.Controller.Controller
import ImageFilters.{BrightnessFilter, FilterHandler, InvertImageFilter, RotateImageFilter}

import scala.collection.mutable.ListBuffer

class ConsoleView(controller: Controller) {
  //todo delete

  //todo create Trait for View with applyCommands ?
  def loadCommands(commands: Array[String]): Unit = {
    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)
  }

  private def parseCommands(commands: Array[String]): List[String] = {
    val parsed = new ListBuffer[String]
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

    parsed.result()
  }

  private def processCommand(command: String): Unit = {
    //todo change this to the labs version
    //Input file
    if (command.startsWith("--image-url")) {
      controller.setInput(command.substring(8))
      return
    }
    else if (command.startsWith("--image-random")) {
      //todo
    }
    else if (command.startsWith("--image")) {
      //todo check for filetype we cant handle .png for example
      controller.setInput(command.substring(8))
      return
    }
    //Output file
    if (command.startsWith("--output-file")) {
      //      println(command.substring(14))
      controller.setOutput(command.substring(14))
      return
    }
    else if (command == "--output-console") {
      controller.setOutput(null)
      return
    }
    //Filters
    if (command.startsWith("--rotate")) {
      //todo try catch this
      val degrees: Int = command.substring(9).toInt
      if (degrees % 90 != 0)
        throw new Exception("Incorrect command format, --rotation supports only 90 degrees rotations")
      controller.addFilter(new RotateImageFilter(degrees))
      return
    }

    else if (command.startsWith("--brightness")) {
      //todo try catch this
      val x: Int = command.substring(13).toInt
      controller.addFilter(new BrightnessFilter(x))
      return
    }
    command match {
      //      case "--rotate" + _ =>
      case "--invert" =>
        controller.addFilter(new InvertImageFilter)
      case _ => throw new Exception("Incorrect command, use \"help\" for help")
    }
  }

}
