package ASCIIArtApp

import ASCIIArtApp.Console.Controller.ConsoleController
import ASCIIArtApp.Console.Views.ConsoleView
import ASCIIArtApp.Exporters.StdOutputExporter
import ASCIIArtApp.Loaders.PathImageLoader

class Application {
  val controller = new ConsoleController
  val cv = new ConsoleView(controller)
//  val loader = new PathImageLoader
//  val exporter = new StdOutputExporter

  def run(args: Array[String]): Unit = {
    cv.loadCommands(args)
    controller.executeCommands()

    //todo finish this
  }

}
