package ASCIIArtApp.Console.Controller

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.{ImageLoader, PathImageLoader}
import Exporters.{FileOutputExporter, StdOutputExporter, TextExporter}
import ImageFilters.{ImageFilter, PixelGridFilter}

import java.io.File
import scala.collection.mutable.ListBuffer

class ConsoleController extends Controller {
  private var img: ImageFacade = _
  private var exporter: TextExporter = _
  private val filters = ListBuffer.empty[PixelGridFilter]

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
  override def setInput(in: String): Unit = {
    //todo check if path or url or do it some other way idfk
    img = new ImageFacade(PathImageLoader.load(in))
  }

  /**
   * Sets the output for the ASCII Art image
   *
   * @param out path for output or null for console
   */
  override def setOutput(out: String): Unit = {
    if (out == null)
      exporter = new StdOutputExporter
    else
      exporter = new FileOutputExporter(new File(out))
  }

  override def addFilter(filter: PixelGridFilter): Unit = {
    //todo check if filter argument is ok and return bool?
    filters += filter
  }

  override def executeCommands(): Unit = {
    img.applyFilters(filters.result())
    img.transform()
  }

  override def export(): Unit = {
    exporter.export(img.toString)
  }
}
