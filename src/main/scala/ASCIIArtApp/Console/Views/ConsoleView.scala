package ASCIIArtApp.Console.Views

import scala.collection.mutable.ListBuffer

class ConsoleView {

  def applyCommands(commands: Array[String]): Unit = {
    val cmds = parseCommands(commands)

    for (i <- cmds) {
      processCommand(i)
    }
  }


  def parseCommands(commands: Array[String]): List[String] = {
    val parsed = new ListBuffer[String]
    var cmd = new String
    var lastWasArg = false

    for (i <- commands) {
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
    }
    if (cmd != "")
      parsed += cmd


    parsed.result()
    //    val res = parsed.result()
    //    for (i <- res) {
    //      println(i)
    //    }
  }

  def processCommand(command: String): Unit = {

    //Input file
    if (command.startsWith("--image")) {
      //todo add file name to controller
    }

    if (command.startsWith("--output-file")) {
      //todo add file name to controller

    }

    if (command.startsWith("--output-console")) {
      //todo set console as output stream in controller
    }
    command match {
      //todo add filter commands
      case _ => throw new Exception("Incorrect command, use \"help\" for help")
    }
  }

}
