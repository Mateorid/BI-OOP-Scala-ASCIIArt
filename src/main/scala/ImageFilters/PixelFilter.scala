package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, Pixel}
import ASCIIArtApp.Models.PixelGrid

trait PixelFilter[T <: Pixel, Y <: Pixel] extends PixelGridFilter[T, Y] {

  override def apply(item: PixelGrid[T]): PixelGrid[Y] =
    item.transform(applyOnPixel)

  protected def applyOnPixel(pixel: T): Y
}
