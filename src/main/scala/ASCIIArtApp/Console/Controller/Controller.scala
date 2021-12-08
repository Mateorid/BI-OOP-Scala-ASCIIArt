package ASCIIArtApp.Console.Controller

import ImageFilters.{Filter, ImageFilter, PixelFilter}

trait Controller {

  /**
   * Shows a help on show to use the UI
   */
  def showHelp(): Unit

  /**
   * Sets the image input
   *
   * @param in URL or path to image
   */
  def setInput(in: String): Unit

  /**
   * Sets the output for the ASCII Art image
   *
   * @param out path for output of nil for console
   */
  def setOutput(out: String): Unit

  def addFilter(filter: ImageFilter): Unit
//  def addFilter(filter: PixelFilter): Unit
//
//  def addFilter(filter: PixelGridFilter): Unit

  def executeCommands(): Unit

  def export(): Unit

  //todo add comments

}
