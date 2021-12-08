package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid

trait PixelFilter extends ImageFilter {

  override def apply(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] =
    item.applyFilterOnPixel(applyOnPixel)

  protected def applyOnPixel(pixel: GSPixel): GSPixel
}
