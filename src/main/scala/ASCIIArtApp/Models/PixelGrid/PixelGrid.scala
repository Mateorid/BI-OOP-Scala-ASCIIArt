package ASCIIArtApp.Models.PixelGrid

abstract class PixelGrid[T](pixelRows: List[List[T]]) {

  def getHeight: Int =
    pixelRows.size

  def getWidth: Int =
    pixelRows(1).length
}
