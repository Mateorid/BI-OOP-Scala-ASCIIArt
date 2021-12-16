package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.GSPixel
import ASCIIArtApp.Transformers.Filters.PixelFilter

class BrightnessFilter(value: Int) extends PixelFilter[GSPixel] {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel = {
    var res: Int = item.value + value
    if (res > 255) res = 255
    if (res < 0) res = 0
    GSPixel(res)
  }
}
