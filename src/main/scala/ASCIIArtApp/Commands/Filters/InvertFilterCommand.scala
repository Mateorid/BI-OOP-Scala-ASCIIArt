package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.RegExCommand
import ASCIIArtApp.ImageFilters.InvertImageFilter
import ASCIIArtApp.UI.Controller.GSFiltersImageController

case class InvertFilterCommand(controller: GSFiltersImageController)
    extends RegExCommand("--invert$".r) {

  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.nonEmpty)
      throw new IllegalArgumentException("--invert takes no arguments")
    controller.addFilter(InvertImageFilter)
  }
}
