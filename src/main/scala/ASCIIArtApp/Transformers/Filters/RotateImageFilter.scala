package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models.{Image, Pixel, PixelGrid}


class RotateImageFilter[T <: Pixel](degrees: Int) extends ImageFilter[T] {
  if (degrees % 90 != 0)
    throw new IllegalArgumentException("--ERROR--\nOnly 90 degrees rotations are currently supported!")

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
      case 270 => rotateLeft(item)
      case _ => rotateRight(rotateRight(item))
    }
  }

  private def rotateLeft(item: Image[T]): Image[T] = {
    var res = Seq.empty[Seq[T]]
    for (j <- item.width - 1 to 0 by -1) {
      var newRow = Seq.empty[T]
      for (i <- 0 until item.height)
        newRow = newRow :+ item.getPixel(i, j)
      res = res :+ newRow
    }
    new Image[T](new PixelGrid[T](res))
  }

  private def rotateRight(item: Image[T]): Image[T] = {
    var res = Seq.empty[Seq[T]]
    for (j <- 0 until item.width) {
      var newRow = Seq.empty[T]
      for (i <- item.height - 1 to 0 by -1)
        newRow = newRow :+ item.getPixel(i, j)
      res = res :+ newRow
    }
    new Image[T](new PixelGrid[T](res))
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
