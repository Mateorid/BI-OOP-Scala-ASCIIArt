package ASCIIArtApp.ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel

object InvertImageFilter extends PixelFilter[GSPixel, GSPixel] {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel =
    GSPixel(255 - item.print().toInt)
}
