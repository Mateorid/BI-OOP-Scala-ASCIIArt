package ASCIIArtApp.ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel

class BrightnessFilter(value: Int) extends PixelFilter[GSPixel, GSPixel] {

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel = {
    var res: Int = item.print().toInt + value
    if (res > 255) res = 255
    if (res < 0) res = 0
    GSPixel(res)
  }
}
