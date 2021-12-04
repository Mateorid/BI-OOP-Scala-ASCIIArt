package ASCIIArtApp

import ASCIIArtApp.Console.Controller.ConsoleController
import ASCIIArtApp.Console.Views.ConsoleView

class Application {
  val controller = new ConsoleController
  val cv = new ConsoleView(controller)

  def run(args: Array[String]): Unit = {
    cv.loadCommands(args)
    controller.executeCommands()
    controller.export()
    //todo finish this?
  }

}