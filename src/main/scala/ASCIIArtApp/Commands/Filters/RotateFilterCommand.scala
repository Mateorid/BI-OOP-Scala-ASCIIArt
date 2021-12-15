package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.RegExCommand
import ASCIIArtApp.ImageFilters.RotateImageFilter
import ASCIIArtApp.UI.Controller.GSFiltersImageController

case class RotateFilterCommand(controller: GSFiltersImageController)
    extends RegExCommand("--rotate (-?\\d+)$".r) {

  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.length != 1)
      throw new IllegalArgumentException(
        "--rotate takes an degrees:Int argument")
    controller.addFilter(new RotateImageFilter(args.head.toInt))
  }
}
