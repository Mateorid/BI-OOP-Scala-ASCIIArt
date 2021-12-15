package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.RegExCommand
import ASCIIArtApp.Loaders.URLRGBImageLoader
import ASCIIArtApp.UI.Controller.GSFiltersImageController

case class URLInputCommand(controller: GSFiltersImageController)
    extends RegExCommand("--image-url (...\\S*)".r) {

  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.length != 1)
      throw new IllegalArgumentException(
        "Invalid URL to image, URL is not a single string")
    controller.setInput(new URLRGBImageLoader(args.head))
  }
}
