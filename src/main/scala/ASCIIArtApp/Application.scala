package ASCIIArtApp

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.UI.Controller.GSFiltersImageController
import ASCIIArtApp.UI.InputHandlers.ConsoleInputHandler

class Application {
  val img = new ImageFacade
  val cc = new GSFiltersImageController(img)
  val cih = new ConsoleInputHandler(cc)

  def run(args: Array[String]): Unit = {
    try {
      cih.handleInput(args)

      //todo finish this?
    } catch {
      case e: Exception => println("--ERROR--" + e)
    }
  }

}
