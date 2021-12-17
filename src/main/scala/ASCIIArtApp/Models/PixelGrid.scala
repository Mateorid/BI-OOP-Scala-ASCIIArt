package ASCIIArtApp.Models

import scala.collection.mutable.ListBuffer

class PixelGrid[T <: Pixel](pixels: List[List[T]]) {

  if (pixels.isEmpty || pixels.head.isEmpty)
    throw new IllegalArgumentException("--ERROR--\nImage is empty!")

  def height: Int = pixels.size

  def width: Int = pixels.head.length

  def getPixel(row: Int, column: Int): T = {
    if (row > height - 1 || row < 0)
      throw new IllegalArgumentException("--ERROR--\nPixel row out of bounds")

    if (column > width - 1 || column < 0)
      throw new IllegalArgumentException("--ERROR--\nPixel column out of bounds")

    pixels(row)(column)
  }

  def transform[Y <: Pixel](filter: T => Y): PixelGrid[Y] = {
    val res = ListBuffer.empty[List[Y]]
    for (i <- 0 until height) {
      val row = ListBuffer.empty[Y]
      for (j <- pixels(i).indices) {
        val pixel = filter(getPixel(i, j))
        row += pixel
      }
      res += row.result()
    }
    new PixelGrid(res.result())
  }
}
