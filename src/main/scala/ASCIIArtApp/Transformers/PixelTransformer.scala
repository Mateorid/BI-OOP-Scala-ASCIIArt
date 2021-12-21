package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{Image, Pixel}

trait PixelTransformer[T <: Pixel, Y <: Pixel] extends ImageTransformer[T, Y] {
  /**
   * Transforms an item into another item
   * @param image image to be transformed
   *  @return transformed image
   */
  override def apply(image: Image[T]): Image[Y] =
    image.transform(applyOnPixel)

  /**
   * Transforms pixel into another pixel
   * @param pixel pixel to be transformed
   * @return transformed pixel
   */
  protected def applyOnPixel(pixel: T): Y
}
