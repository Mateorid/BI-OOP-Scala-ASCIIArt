package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, Pixel}
import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait PixelFilter[T <: Pixel[_]] extends ImageFilter[PixelGrid[T]] {

  override def apply(item: PixelGrid[T]): PixelGrid[T] =
    item.applyFilterOnPixel(applyOnPixel)

  //todo how to fix this - again problem with the pixels
  protected def applyOnPixel(pixel: T): T
}
