package ImageFilters

import ASCIIArtApp.Models.PixelGrid.GSGrid

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class FilterHandler {
  val filters: ListBuffer[ImageFilter[GSGrid]] =
    ListBuffer.empty[ImageFilter[GSGrid]]
  def addFilter(filter: ImageFilter[_]): Unit =
    filters += filter
}
