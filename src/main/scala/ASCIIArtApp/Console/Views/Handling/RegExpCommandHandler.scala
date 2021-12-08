package ASCIIArtApp.Console.Views.Handling

import scala.util.matching.Regex

abstract class RegExpCommandHandler(val regExp: Regex) extends CommandHandler {

  override def handle(command: String): Option[Handler[String]] =
    command match {
      case regExp(all @ _*) =>
        processCommand(all)
        None
      case _ => super.handle(command)
    }

  def commandName: String
}
