package ASCIIArtApp

object Main extends App {

  val app = new Application
  app.run(Main.args)

  //todo-----otazky----
  //how to fix having the problem with Pixel/PixelGrids & filters .get() / .value or something
  //v pixel filteru jde nejak nastavi o jaky typ pixelu se jedna pomoci method generics?


  //todo InputHandler more OOP
  //todo importer based on file type?
  //todo extract 'transformers' from filters?
  //todo change exporters to export Image instead of string? - some adapter

  //todo nemusime testovat stdoutstream?
  //todo if exception - close exporters?
  //todo extend pixelGrid with Image classes based
  //todo change List to Seq
  //todo better OOP style filters - Matej
  //todo give lab credits in the Console input section
  //todo change the 2d List iterations to be dynamic based on actual numbers of pixels in that row to avoid .png crashes
}
