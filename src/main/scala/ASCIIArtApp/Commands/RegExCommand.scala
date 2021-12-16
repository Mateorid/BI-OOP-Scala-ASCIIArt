package ASCIIArtApp.Commands

import scala.util.matching.Regex

abstract class RegExCommand(val regEx: Regex) extends TextCommand {
  override def run(command: String): Unit = {
    command match {
      case regEx(all@_*) =>
        processCommand(all)
      case _ => processCommand(Seq.empty[String])
    }

    def getRegEx: Regex = regEx
  }
}
