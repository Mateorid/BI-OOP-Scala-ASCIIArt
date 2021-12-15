package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Commands.RegExCommand
import ASCIIArtApp.Exporters.StdOutputExporter
import ASCIIArtApp.UI.Controller.GSFiltersImageController

case class ConsoleOutputCommand(controller: GSFiltersImageController)
    extends RegExCommand("--output-console$".r) {

  override protected def processCommand(args: Seq[String]): Unit =
    controller.setOutput(StdOutputExporter)
}
