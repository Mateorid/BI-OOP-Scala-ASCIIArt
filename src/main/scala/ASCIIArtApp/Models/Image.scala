package ASCIIArtApp.Models

class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  def height: Int = pixelGrid.height

  def width: Int = pixelGrid.width

  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  def transform[Y <: Pixel](func: T => Y): Image[Y] =
    new Image[Y](pixelGrid.transform(func))

  override def equals(obj: Any): Boolean = {
    obj match {
      case obj: Image[T] =>
        //sorry for duplicate code I couldn't figure out how to make an iterator :(
        if (obj.height != height || obj.width != width)
          return false
        for (h <- 0 until height; w <- 0 until width) {
          if (getPixel(h, w) != obj.getPixel(h, w))
            return false
        }
        true
      case _ => false
    }
  }
}
