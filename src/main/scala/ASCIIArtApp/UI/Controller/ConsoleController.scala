package ASCIIArtApp.UI.Controller

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.{PathImageLoader, RandomImageLoader, URLImageLoader}
import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid
import Exporters.{FileOutputExporter, StdOutputExporter, TextExporter}
import ImageFilters.{Filter, PixelGridFilter}

import java.io.File
import scala.collection.mutable.ListBuffer

class ConsoleController(img: ImageFacade) extends Controller[PixelGrid[GSPixel], PixelGrid[GSPixel]] {
  private var exporter: TextExporter = _
  private val imageFilters = ListBuffer.empty[PixelGridFilter[GSPixel, GSPixel]]

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
  //todo change it to addFilter way & have a separate command in the consoleView "--image-url"
    try {
      if (in == null)
        img = new ImageFacade(RandomImageLoader.load(null))
      if (in.startsWith("http"))
      //todo fails to load .gif?
        img = new ImageFacade(URLImageLoader.load(in))
      else
        img = new ImageFacade(PathImageLoader.load(in))
    } catch {
      case e: Throwable =>
        println(
          "--ERROR--\nFailed to load this file, make sure the file exist\n" + e)
        //todo do this better?
        throw new Exception()
    }

  /**
   * Sets the output for the ASCII Art image
   *
   * @param out path for output or null for console
   */
  override def setOutput(out: String): Unit =
    if (out == null)
      exporter = new StdOutputExporter
    else
      exporter = new FileOutputExporter(new File(out))

  override def addFilter(filter: Filter[PixelGrid[GSPixel], PixelGrid[GSPixel]]): Unit = imageFilters += filter

  override def executeCommands(): Unit = {
    img.applyFilters(imageFilters.result())
    img.transformToASCII()
  }

  override def export(): Unit =
    exporter.export(img.toString)
}
