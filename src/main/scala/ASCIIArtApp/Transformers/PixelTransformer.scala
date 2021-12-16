package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{Image, Pixel}

trait PixelTransformer[T <: Pixel, Y <: Pixel] extends ImageTransformer[T, Y] {
  override def apply(item: Image[T]): Image[Y] =
    item.transform(applyOnPixel)

  protected def applyOnPixel(pixel: T): Y
}
