package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

import scala.collection.mutable.ListBuffer

class InvertImageFilter extends PixelGridFilter {
  override val priority: Int = 3

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  override def apply(item: PixelGrid[GSPixel]): PixelGrid[GSPixel] = {
    val newGrid = ListBuffer.empty[List[GSPixel]]
    for (i <- 0 until item.height) {
      val newRow = ListBuffer.empty[GSPixel]
      for (j <- 0 until item.width) {
        val newPixel = GSPixel(255 - item.getPixels(i)(j).get())
        newRow += newPixel
      }
      newGrid += newRow.result()
    }
    new PixelGrid(newGrid.result())
  }
}
