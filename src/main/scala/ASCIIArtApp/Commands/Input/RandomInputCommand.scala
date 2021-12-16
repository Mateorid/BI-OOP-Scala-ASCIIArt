//package ASCIIArtApp.Commands.Input
//
//import ASCIIArtApp.Commands.RegExCommand
//import ASCIIArtApp.Loaders.RGBImageLoaders.RandomRGBImageLoader
//import ASCIIArtApp.UI.Controller.GSFiltersImageController
//
//case class RandomInputCommand(controller: GSFiltersImageController)
//    extends RegExCommand("--image-random (\\d+ \\d+)$".r) {
//
//  override protected def processCommand(args: Seq[String]): Unit = {
//    if (args.length != 2)
//      throw new IllegalArgumentException(
//        "--image-random takes 2 input arguments height X width of the image")
//    controller.setInput(
//      new RandomRGBImageLoader(args.head.toInt, args(1).toInt))
//  }
//}
