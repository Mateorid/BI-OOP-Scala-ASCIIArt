package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.RegExCommand
import ASCIIArtApp.Loaders.PathRGBImageLoader
import ASCIIArtApp.UI.Controller.GSFiltersImageController

case class PathInputCommand(controller: GSFiltersImageController)
    extends RegExCommand("--image (\\S*)$".r) {

  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.length != 1)
      throw new IllegalArgumentException(
        "Invalid path to image, path is not a single string")
    controller.setInput(new PathRGBImageLoader(args.head))
  }
}
