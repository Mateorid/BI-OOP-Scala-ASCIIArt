package ASCIIArtApp.UI.Controller

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.{PathImageLoader, RandomImageLoader, URLImageLoader}
import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid
import Exporters.{FileOutputExporter, StdOutputExporter, TextExporter}
import ImageFilters.{Filter, PixelGridFilter}

import java.io.File
import scala.collection.mutable.ListBuffer

class ConsoleController(img: ImageFacade){ //todo extend from Controller - how?
  private var exporter: TextExporter = _
  private val imageFilters = ListBuffer.empty[PixelGridFilter[GSPixel, GSPixel]]

  /**
   * Sets the image input
   *
   * @param in URL or path to image
   */
  def setInput(in: String): Unit =
  //todo change it to addFilter way & have a separate command in the consoleView "--image-url"
    try {
      if (in == null)
        img.setRGB(RandomImageLoader.load(null))
      if (in.startsWith("http"))
      //todo fails to load .gif?
        img.setRGB(URLImageLoader.load(in))
      else
        img.setRGB(PathImageLoader.load(in))
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
  def setOutput(out: String): Unit =
    if (out == null)
      exporter = new StdOutputExporter
    else
      exporter = new FileOutputExporter(new File(out))

  def addFilter(filter: PixelGridFilter[GSPixel, GSPixel]): Unit = imageFilters += filter

  def executeCommands(): Unit = {
    img.applyFilters(imageFilters.result())
  }

  def export(): Unit =
    exporter.export(img.toString)
}
