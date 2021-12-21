package ASCIIArtApp.Models


//Currently just wraps the PixelGrid class - creating this was a mistake :)
class Image[T <: Pixel](pixelGrid: PixelGrid[T]) {
  def height: Int = pixelGrid.height

  def width: Int = pixelGrid.width

  /**
   * Returns the pixel from given position
   *
   * @return pixel from given position
   */
  def getPixel(row: Int, column: Int): T = pixelGrid.getPixel(row, column)

  /**
   * Applies given transforming function on this Image
   *
   * @param func transforming function
   * @tparam Y Type of pixel that are current pixels being transformed to
   * @return image with the transforming function applied
   */
  def transform[Y <: Pixel](func: T => Y): Image[Y] =
    new Image[Y](pixelGrid.transform(func))

  override def equals(obj: Any): Boolean = {
    obj match {
      case obj: Image[T] =>
        //sorry for duplicate code I couldn't figure out how to make an iterator, I am a failure :(
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
