package ASCIIArtApp.Console.Controller

import ASCIIArtApp.Exporters.{Exporter, TextExporter}
import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.PathImageLoader
import ASCIIArtApp.Models.Image.RGBImage
import ASCIIArtApp.Models.PixelGrid.RGBGrid

class ConsoleController extends Controller {
  var input: String = _
  var output: String = _

  /**
   * Shows a help on show to use the UI
   */
  override def showHelp(): Unit = {
    //todo?
    println("Use \"--image {input image path or URL}\" to set input image")
    println("Use \"--output-console\" to use console as output stream")
    println("Use \"--output-file {path}\" to output at given path")
    println("Use \"--help\" to print this helping message")
  }

  /**
   * Sets the image input
   *
   * @param in URL or path to image
   */
  override def setInput(in: String): Unit =
    //todo where should the input be stored?
    input = in

  /**
   * Sets the output for the ASCII Art image
   *
   * @param out path for output or null for console
   */
  override def setOutput(out: String): Unit =
    //todo create an export controller?
    if (out == null) {}

  def executeCommands(): Unit = {
    val loader = new PathImageLoader
    val img = new ImageFacade(loader.load(input))
    val res = img.transform()
    res.print
  }
}
