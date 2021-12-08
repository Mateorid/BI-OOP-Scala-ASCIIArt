package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, Pixel}
import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait PixelFilter extends ImageFilter {
  override def apply(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] =
    item.applyFilterOnPixel(applyOnPixel)
  //todo how to fix this - again problem with the pixels

  protected def applyOnPixel(pixel: GSPixel): GSPixel
}
