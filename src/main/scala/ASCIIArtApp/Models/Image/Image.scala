package ASCIIArtApp.Models.Image

import ASCIIArtApp.Models.Pixel.Pixel
import ASCIIArtApp.Models.PixelGrid

class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  val height: Int = pixelGrid.height

  val width: Int = pixelGrid.width

  def applyPixelFilter[Y <: Pixel](filter: T => Y): Image[Y] = new Image(pixelGrid.transform(filter))

  def applyGridFilter[Y <: Pixel](filter: PixelGrid[T] => PixelGrid[Y]): Image[Y] = {
    new Image(filter.apply(pixelGrid))
  }

  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  override def toString: String = pixelGrid.toString

}
