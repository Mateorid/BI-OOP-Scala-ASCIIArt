package ASCIIArtApp.Console.Views

import ASCIIArtApp.Console.Controller.Controller
import ImageFilters.InvertImageFilter

import scala.collection.mutable.ListBuffer

class ConsoleView(controller: Controller) {

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

    //Input file
    if (command.startsWith("--image")) {
      //todo check for filetype - cant handle .png for example
      if (command.startsWith("--image-random")) {
        //todo
      } else {
        //todo add check if path or url - can be done by using different command for url reading
        controller.setInput(command.substring(8))
      }
      //println(command.substring(8))
      return
    }

    if (command.startsWith("--output-file")) {
      //      println(command.substring(14))
      controller.setOutput(command.substring(14))
      return
    }

    if (command == "--output-console") {
            println("console XDD")
      controller.setOutput(null)
      return
    }
    command match {
//      case "--rotate" + _ =>
      case "--invert" =>
        val filter = new InvertImageFilter
        controller.addFilter(filter )
      case _ => throw new Exception("Incorrect command, use \"help\" for help")
    }
  }

}
