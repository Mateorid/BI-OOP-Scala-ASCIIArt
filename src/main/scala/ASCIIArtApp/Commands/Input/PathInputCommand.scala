//package ASCIIArtApp.Commands.Input
//
//import ASCIIArtApp.Commands.RegExCommand
//import ASCIIArtApp.Loaders.RGBImageLoaders.PathRGBImageLoader
//import ASCIIArtApp.UI.Controller.GSFiltersImageController
//
//case object PathInputCommand extends RegExCommand("--image (\\S*)$".r) {
//
//  override protected def processCommand(args: Seq[String]): Unit =
//    if (args.length != 1)
//      throw new IllegalArgumentException(
//        "Invalid path! Path is not a single string")
//
////    controller.setInput(new PathRGBImageLoader(args.head))
////todo
//}
