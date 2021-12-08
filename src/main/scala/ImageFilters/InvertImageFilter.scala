package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

import scala.collection.mutable.ListBuffer

class InvertImageFilter extends PixelFilter {
  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def applyOnPixel(item: GSPixel): GSPixel =
    GSPixel(255 - item.get())
}
