package ASCIIArtApp

import ASCIIArtApp.Config.Config
import ASCIIArtApp.UI.ConsoleInputHandler
import com.sun.jdi.InvalidTypeException

object Main extends App {
  val config = new Config
  val cih = new ConsoleInputHandler(config)

  try cih.handleInput(args)
  catch {
    case e: IllegalArgumentException => println(e.getMessage)
    case e: NullPointerException => println(e.getMessage)
    case e: Exception => println("--Unexpected error--\n" + e)
    case e: Any => println("--Very unexpected error--\n" + e)
  }
}

//todo do poznamek pri odevzdani pridat to ze muj --image-random bere argumenty

//todo T E S T S
//todo make loading better? - traits and stuff
//todo importer based on file type?

//todo add flip filter?
//todo change exporters to export Image instead of string?

//todo nemusime testovat stdoutstream?
//todo change List to Seq