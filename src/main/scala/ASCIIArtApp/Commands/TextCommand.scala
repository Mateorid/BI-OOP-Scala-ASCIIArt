package ASCIIArtApp.Commands

trait TextCommand extends Command[String] {

  protected def processCommand(args: Seq[String]): Unit
}
