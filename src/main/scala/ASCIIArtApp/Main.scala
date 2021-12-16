package ASCIIArtApp

import ASCIIArtApp.UI.ConsoleInputHandler

object Main extends App {

  try ConsoleInputHandler.handleInput(args)
  catch {
    case e: Exception => println("--ERROR--\n" + e)
  }
}

//todo InputHandler more OOP
//todo throw exception if >1 inputs/outputs
//todo importer based on file type?
//todo extract 'transformers' from filters? - redo this better so I can have list of ImageFilters
//todo add flip filter?
//todo change exporters to export Image instead of string? - some adapter - change to only output once and close the stream

//todo nemusime testovat stdoutstream?
//todo if exception - close exporters?
//todo extend pixelGrid with Image classes based
//todo change List to Seq

//todo give lab credits in the Console input section
//todo change the 2d List iterations to be dynamic based on actual numbers of pixels in that row to avoid .png crashes
