package ASCIIArtApp.Console

import ASCIIArtApp.Application

object Main extends App {

  val app = new Application
  app.run(Main.args)

  //todo change List to Seq
  //todo change the 2d List iterations to be dynamic based on actual numbers of pixels in that row to avoid .png crashes
}
