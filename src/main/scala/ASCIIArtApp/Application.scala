package ASCIIArtApp

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.UI.Controller.ConsoleController
import ASCIIArtApp.UI.InputHandlers.ConsoleInputHandler

class Application {
  val img = new ImageFacade
  val cc = new ConsoleController(img)
  val civ = new ConsoleInputHandler(cc)

  def run(args: Array[String]): Unit = {
    try {
      civ.handleInput(args)
      //todo finish this?
    } catch {
      case e: Exception => println("--ERROR--" + e)
    }
  }

}
