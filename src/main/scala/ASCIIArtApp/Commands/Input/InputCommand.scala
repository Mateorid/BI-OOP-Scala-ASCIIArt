package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config

abstract class InputCommand(config: Config) extends Command {
  override def run(): Unit = {
    if (config.loader != null)
      throw new IllegalArgumentException("There can only be 1 image input!")
    addLoader()
  }

  protected def addLoader(): Unit

}
