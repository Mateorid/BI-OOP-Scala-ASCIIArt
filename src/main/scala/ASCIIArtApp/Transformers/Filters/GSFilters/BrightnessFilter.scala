package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.GSPixel
import ASCIIArtApp.Transformers.Filters.PixelFilter

class BrightnessFilter(val value: Int) extends PixelFilter[GSPixel] {
  if (value < -255 || value > 255)
    throw new IllegalArgumentException("--ERROR--\nBrightness value must be between -255 & +255")


  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel = {
    if (value == 0)
      return item
    var res: Int = item.value + value
    if (res > 255) res = 255
    if (res < 0) res = 0
    GSPixel(res)
  }
}
