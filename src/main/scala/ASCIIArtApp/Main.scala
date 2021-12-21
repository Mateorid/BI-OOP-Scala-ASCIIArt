package ASCIIArtApp

import ASCIIArtApp.AppExecutionLogic.ImageTransformation
import ASCIIArtApp.Config.Config
import ASCIIArtApp.UI.ConsoleInputHandler

object Main extends App {
  val config = new Config
  val cih = new ConsoleInputHandler(config, ImageTransformation)

  try cih.handleInput(args)
  catch {
    case e: IllegalArgumentException => println(e.getMessage)
    case e: NullPointerException => println(e.getMessage)
    case e: Exception => println("--Unexpected error--\n" + e)
    case e: Any => println("--Very unexpected error--\n" + e)
  }
}
//todo T E S T S - loaders
//todo okomentovat :(

//todo do poznamek pri odevzdani pridat to ze muj --image-random bere argumenty

//todo add flip filter? or at least delete it KEKW
//todo change exporters to export Image instead of string?