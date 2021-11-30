import ASCIIArtApp.Console.Views.ConsoleView
import ASCIIArtApp.Exporters.StdOutputExporter
import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.PathImageLoader


object Main extends App {

  val cv = new ConsoleView
  val commands = cv.parseCommands(Main.args)


  val loader = new PathImageLoader
  val exporter = new StdOutputExporter

  val bi = loader.load("src/main/scala/TestImages/test.jpg")
  val imgFacade = new ImageFacade(bi)

  //  todo
  exporter.export(imgFacade.getGrid.pixelRows.toString())
  exporter.close()
}