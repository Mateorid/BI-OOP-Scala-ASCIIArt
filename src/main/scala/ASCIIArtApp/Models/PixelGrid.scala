package ASCIIArtApp.Models

import ASCIIArtApp.Models.Pixel.Pixel

import scala.collection.mutable.ListBuffer

class PixelGrid[T <: Pixel](private val pixels: List[List[T]]) {
  val height: Int = pixels.size

  def getPixels: List[List[T]] =
    pixels

  def applyFilterOnPixel(filter: T => T): PixelGrid[T] = {
    val res = ListBuffer.empty[List[T]]
    for (i <- 0 until height) {
      val row = ListBuffer.empty[T]
      for (j <- pixels(i).indices) {
        val pixel = filter(pixels(i)(j))
        row += pixel
      }
      res += row.result()
    }
    new PixelGrid(res.result())
  }

  def print: String = {
    var res: String = ""
    for (i <- 0 until height) {
      for (j <- pixels(i).indices)
        res += pixels(i)(j).print()
      res += "\n"
    }
    res
  }
}
