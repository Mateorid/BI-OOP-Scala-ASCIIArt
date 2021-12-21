package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models.{Image, Pixel, PixelGrid}

/**
 * Rotate image filter
 *
 * @param degrees degrees by how much should the image be rotated
 * @tparam T image pixel type
 */
class RotateImageFilter[T <: Pixel](val degrees: Int) extends ImageFilter[T] {
  if (degrees % 90 != 0)
    throw new IllegalArgumentException("--ERROR--\nOnly 90 degrees rotations are currently supported!")

  /**
   * Applies a rotate filter on image
   *
   * @param image image to be transformed
   * @return transformed image
   */
  override def apply(image: Image[T]): Image[T] = {
    val actualDegrees: Int = degrees % 360

    actualDegrees match {
      case 0 => image
      case 90 => rotateRight(image)
      case -270 => rotateRight(image)
      case -90 => rotateLeft(image)
      case 270 => rotateLeft(image)
      case _ => rotateRight(rotateRight(image))
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
}
