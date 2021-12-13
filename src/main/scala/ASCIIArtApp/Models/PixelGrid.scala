package ASCIIArtApp.Models

import ASCIIArtApp.Models.Pixel.Pixel

import scala.collection.mutable.ListBuffer

class PixelGrid[T <: Pixel](pixels: List[List[T]]) {
  val height: Int = pixels.size
  val width: Int = pixels.head.length

  def getPixel(row: Int, column: Int): T = {
    if (row > height - 1 || row < 0)
      throw new IllegalArgumentException("Pixel row out of bounds")

    if (column > width - 1 || column < 0)
      throw new IllegalArgumentException("Pixel column out of bounds")

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

  override def toString: String = {
    var res: String = ""
    for (row <- 0 until height) {
      for (col <- pixels(row).indices) {
        res += getPixel(row, col).print()
      }
      res += "\n"
    }
    res
  }
}
