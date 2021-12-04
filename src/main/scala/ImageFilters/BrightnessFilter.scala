package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

class BrightnessFilter(value: Int) extends GSPixelFilter {
  override val priority: Int = 3 //todo

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def apply(item: GSPixel): GSPixel = {
    var res = item.get() + value
    if (res > 255) res = 255
    if (res < 0) res = 0
    GSPixel(res)
  }
}
