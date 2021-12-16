package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models.{Image, Pixel, PixelGrid}

import scala.collection.mutable.ListBuffer

class RotateImageFilter[T <: Pixel](degrees: Int) extends ImageFilter[T] {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def apply(item: Image[T]): Image[T] = {
    val actualDegrees: Int = degrees % 360

    actualDegrees match {
      case 0 => item
      case 90 => rotateRight(item)
      case -270 => rotateRight(item)
      case -90 => rotateLeft(item)
      case 270 => rotateRight(item)
      case _ => rotateRight(rotateRight(item))
    }
  }

  private def rotateLeft(item: Image[T]): Image[T] = {
    val res = ListBuffer.empty[List[T]]
    for (j <- item.height - 1 to 0 by -1) {
      val newRow = ListBuffer.empty[T]
      for (i <- 0 until item.width)
        newRow += item.getPixel(i, j)
      res += newRow.result()
    }
    new Image[T](new PixelGrid[T](res.result()))
  }

  private def rotateRight(item: Image[T]): Image[T] = {
    val res = ListBuffer.empty[List[T]]
    for (j <- 0 until item.height) {
      val newRow = ListBuffer.empty[T]
      for (i <- item.width - 1 to 0 by -1)
        newRow += item.getPixel(i, j)
      res += newRow.result()
    }
    new Image[T](new PixelGrid[T](res.result()))
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
