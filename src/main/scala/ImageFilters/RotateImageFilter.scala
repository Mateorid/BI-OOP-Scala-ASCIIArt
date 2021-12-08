package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

import scala.collection.mutable.ListBuffer

class RotateImageFilter(degrees: Int) extends ImageFilter {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def apply(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
    val actualDegrees: Int = degrees % 360

    actualDegrees match {
      case 0    => item
      case 90   => rotateRight(item)
      case -270 => rotateRight(item)
      case -90  => rotateLeft(item)
      case 270  => rotateRight(item)
      case _    => rotateRight(rotateRight(item))
    }
  }

  private def rotateLeft(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
    val res = ListBuffer.empty[List[GSPixel]]
    for (j <- item.height - 1 to 0 by -1) {
      val newRow = ListBuffer.empty[GSPixel]
      for (i <- 0 until item.width) {
        val pixel: GSPixel = item.getPixels(i)(j)
        newRow += pixel
      }
      res += newRow.result()
    }
    new PixelGrid[GSPixel](res.result())
  }

  private def rotateRight(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
    val res = ListBuffer.empty[List[GSPixel]]
    for (j <- 0 until item.height) {
      val newRow = ListBuffer.empty[GSPixel]
      for (i <- item.width - 1 to 0 by -1) {
        val pixel: GSPixel = item.getPixels(i)(j)
        newRow += pixel
      }
      res += newRow.result()
    }
    new PixelGrid[GSPixel](res.result())
  }
  //todo this mirrors the image XD
  //  private def rotateLeft(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
  //    val res = ListBuffer.empty[List[GSPixel]]
  //    for (i <- 0 until item.width) {
  //      val newRow = ListBuffer.empty[GSPixel]
  //      for (j <- item.height - 1 to 0 by -1) {
  //        val pixel: GSPixel = item.getPixels(i)(j)
  //        newRow += pixel
  //      }
  //      res += newRow.result()
  //    }
  //    new PixelGrid[GSPixel](res.result())
  //  }

}
