package ASCIIArtApp.ImageFilters

import ASCIIArtApp.Models.Pixel.Pixel
import ASCIIArtApp.Models.PixelGrid

trait PixelFilter[T <: Pixel, Y <: Pixel] extends PixelGridFilter[T, Y] {

  override def applyFilter(item: PixelGrid[T]): PixelGrid[Y] =
    item.transform(applyOnPixel)

  protected def applyOnPixel(pixel: T): Y
}
