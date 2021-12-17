package ASCIIArtApp.Models

class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  val height: Int = pixelGrid.height

  val width: Int = pixelGrid.width

  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  def transform[Y <: Pixel](func: T => Y): Image[Y] =
    new Image[Y](pixelGrid.transform(func))
}
