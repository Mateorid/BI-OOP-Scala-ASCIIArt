package ASCIIArtApp.Console.Controller

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.{ImageLoader, PathImageLoader, URLImageLoader}
import ASCIIArtApp.Models.PixelGrid.GSGrid
import Exporters.{FileOutputExporter, StdOutputExporter, TextExporter}
import ImageFilters.{Filter, ImageFilter, PixelFilter}

import java.io.File
import scala.collection.mutable.ListBuffer

class ConsoleController extends Controller {
  private var img: ImageFacade = _
  private var exporter: TextExporter = _
//  private val pixelFilters = ListBuffer.empty[PixelFilter]
//  private val gridFilters = ListBuffer.empty[PixelGridFilter]
  private var imageFilters = Seq.empty[ImageFilter[_]]

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
    //todo change it to addFilter way & have a separate command in the consoleView "--imgage-url"
    try if (in.startsWith("http"))
      //todo fails to load .gif?
      img = new ImageFacade(URLImageLoader.load(in))
    else
      img = new ImageFacade(PathImageLoader.load(in))
    catch {
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

  override def addFilter(filter: ImageFilter[_]): Unit =
    imageFilters = imageFilters :+ (filter)

//  override def addFilter(filter: PixelFilter): Unit =
//    //todo check if filter argument is ok and return bool?
//    pixelFilters += filter
//
//  override def addFilter(filter: PixelGridFilter): Unit =
//    gridFilters += filter

  override def executeCommands(): Unit = {
//    img.applyFilters(pixelFilters.result(), gridFilters.result())
    img.applyFilters(imageFilters)
    img.transform()
  }

  override def export(): Unit =
    exporter.export(img.toString)
}
