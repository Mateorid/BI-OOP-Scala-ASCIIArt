//package ASCIIArtApp.Commands.Output
//
//import ASCIIArtApp.Commands.RegExCommand
//import ASCIIArtApp.Exporters.FileOutputExporter
//import ASCIIArtApp.UI.Controller.GSFiltersImageController
//
//import java.io.File
//
//case class FileOutputCommand(controller: GSFiltersImageController)
//    extends RegExCommand("--output-file (\\S+)$".r) {
//
//  override protected def processCommand(args: Seq[String]): Unit = {
//    if (args.length != 1)
//      throw new IllegalArgumentException(
//        "Invalid path to file, path is not a single string")
//    controller.setOutput(new FileOutputExporter(new File(args.head)))
//  }
//}
