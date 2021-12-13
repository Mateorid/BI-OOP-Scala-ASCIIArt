package ASCIIArtApp.UI.Controller

import ASCIIArtApp.Models.Pixel.Pixel
import ImageFilters.{Filter, PixelGridFilter}

trait Controller[T, Y] {

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

  def addFilter(filter: Filter[T, Y]): Unit

  def executeCommands(): Unit

  def export(): Unit

  //todo add comments

}
