package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.Pixel
import scala.collection.mutable.ListBuffer

//todo to trait
class PixelGrid[T <: Pixel[_]](pixelRows: List[List[T]]) {
  val height: Int = pixelRows.size
  val width: Int = pixelRows(1).length

  def getPixels: List[List[T]] =
    pixelRows

  def applyFilterOnPixel(filter: T => T): PixelGrid[T] = {
    val res = ListBuffer.empty[List[T]]
    for (i <- 0 until height) {
      val row = ListBuffer.empty[T]
      for (j <- 0 until width) {
        val pixel = filter(pixelRows(i)(j))
        row += pixel
      }
      res += row.result()
    }
    new PixelGrid(res.result())
  }

  def print: String = {
    var res: String = ""
    for (i <- 0 until height) {
      for (j <- 0 until width)
        res += pixelRows(i)(j).get()
      res += "\n"
    }
    res
  }
}
