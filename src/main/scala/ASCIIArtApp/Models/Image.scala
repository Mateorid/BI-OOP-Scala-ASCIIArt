package ASCIIArtApp.Models

class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  val height: Int = pixelGrid.height

  val width: Int = pixelGrid.width

  def applyPixelFilter[Y <: Pixel](filter: T => Y): Image[Y] =
    new Image(pixelGrid.transform(filter))

  def applyGridFilter[Y <: Pixel](
                                   filter: PixelGrid[T] => PixelGrid[Y]): Image[Y] = {
    val newGrid = filter(pixelGrid)
    new Image(newGrid)
  }

  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  def transform[Y <: Pixel](func: T => Y): Image[Y] =
    new Image[Y](pixelGrid.transform(func))
}
