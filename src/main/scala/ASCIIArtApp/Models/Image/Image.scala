package ASCIIArtApp.Models.Image

import ASCIIArtApp.Models.Pixel.Pixel
import ASCIIArtApp.Models.PixelGrid

class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  val height: Int = pixelGrid.height

  val width: Int = pixelGrid.width

  def applyFilter[Y <: Pixel](filter: T => Y): Image[Y] = new Image(pixelGrid.transform(filter))

  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  override def toString: String = pixelGrid.toString

}
