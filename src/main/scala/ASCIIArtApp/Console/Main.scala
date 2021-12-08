package ASCIIArtApp.Console

import ASCIIArtApp.Application

object Main extends App {

  val app = new Application
  app.run(Main.args)

  //todo fuck this all and do filters only on grayscale image
  //todo how to fix having the problem with Pixel/PixelGrids & filters
  //todo extend pixelGrid with Image classes based
  //todo change List to Seq
  //todo better OOP style filters - Matej
  //todo give lab credits in the Console input section
  //todo change the 2d List iterations to be dynamic based on actual numbers of pixels in that row to avoid .png crashes
}
