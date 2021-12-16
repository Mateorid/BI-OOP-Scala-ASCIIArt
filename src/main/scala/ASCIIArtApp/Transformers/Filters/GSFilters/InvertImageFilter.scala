package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.GSPixel
import ASCIIArtApp.Transformers.Filters.PixelFilter

object InvertImageFilter extends PixelFilter[GSPixel] {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel =
    GSPixel(255 - item.value)
}
