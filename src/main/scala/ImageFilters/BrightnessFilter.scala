package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

class BrightnessFilter(value: Int) extends PixelGridFilter {
  override val priority: Int = 3 //todo

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def apply(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
    //todo
    item
  }
}