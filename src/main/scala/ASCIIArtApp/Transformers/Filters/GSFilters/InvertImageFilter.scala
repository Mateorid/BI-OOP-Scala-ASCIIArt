package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.GSPixel
import ASCIIArtApp.Transformers.Filters.PixelFilter

object InvertImageFilter extends PixelFilter[GSPixel] {

  /**
   * Inverts the GS value of the pixel
   *
   * @param pixel pixel to invert
   * @return pixel with inverted value
   */
  override def applyOnPixel(pixel: GSPixel): GSPixel =
    GSPixel(255 - pixel.value)
}
