import ASCIIArtApp.Application
import ASCIIArtApp.Console.Controller.ConsoleController
import ASCIIArtApp.Console.Views.ConsoleView
import ASCIIArtApp.Exporters.StdOutputExporter
import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.PathImageLoader

object Main extends App {

//  val controller = new ConsoleController
//  val cv = new ConsoleView(controller)
//  val loader = new PathImageLoader
//  val exporter = new StdOutputExporter
//
//  val commands = cv.parseCommands(Main.args)
//
//  cv.applyCommands(Main.args)
//  val bi = loader.load("src/main/scala/TestImages/test.jpg")
//  val imgFacade = new ImageFacade(bi)
//
//  todo
//  exporter.export(imgFacade.getGrid.pixelRows.toString())
//  exporter.close()

  val app = new Application
  app.run(Main.args)
}
