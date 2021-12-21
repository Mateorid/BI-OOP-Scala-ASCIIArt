package ASCIIArtApp.Models

//Class that holds the pixels
class PixelGrid[T <: Pixel](pixels: Seq[Seq[T]]) {

  if (pixels.isEmpty || pixels.head.isEmpty)
    throw new IllegalArgumentException("--ERROR--\nImage is empty!")

  def height: Int = pixels.size

  def width: Int = pixels.head.length

  /**
   * Returns the pixel from given position
   *
   * @return pixel from given position
   */
  def getPixel(row: Int, column: Int): T = {
    if (row > height - 1 || row < 0)
      throw new IllegalArgumentException("--ERROR--\nPixel row out of bounds")

    if (column > width - 1 || column < 0)
      throw new IllegalArgumentException("--ERROR--\nPixel column out of bounds")

    pixels(row)(column)
  }

  /**
   * Applies given transforming function on this PixelGrid
   *
   * @param func transforming function
   * @tparam Y Type of pixel that are current pixels being transformed to
   * @return PixelGrid with the transforming function applied
   */
  def transform[Y <: Pixel](func: T => Y): PixelGrid[Y] = {
    var res = Seq.empty[Seq[Y]]
    for (i <- 0 until height) {
      var row = Seq.empty[Y]
      for (j <- pixels(i).indices) {
        val pixel = func(getPixel(i, j))
        row = row :+ pixel
      }
      res = res :+ row
    }
    new PixelGrid(res)
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case obj: PixelGrid[T] =>
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
