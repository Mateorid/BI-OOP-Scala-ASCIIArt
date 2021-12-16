//package ASCIIArtApp.Commands.Filters
//
//import ASCIIArtApp.Commands.RegExCommand
//import ASCIIArtApp.Transformers.Filters.GSFilters.BrightnessFilter
//import ASCIIArtApp.UI.Controller.GSFiltersImageController
//
//case class BrightnessFilterCommand(controller: GSFiltersImageController)
//    extends RegExCommand("--brightness (-?\\d+)$".r) {
//
//  override protected def processCommand(args: Seq[String]): Unit = {
//    if (args.length != 1)
//      throw new IllegalArgumentException("--brightness takes an Int argument")
//    controller.addFilter(new BrightnessFilter(args.head.toInt))
//  }
//}
