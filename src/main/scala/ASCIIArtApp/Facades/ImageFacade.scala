package ASCIIArtApp.Facades

import ASCIIArtApp.Models.Pixel.RGBPixel
import ASCIIArtApp.Models.PixelGrid.RGBGrid

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

class ImageFacade(bi: BufferedImage) {
  private val height = bi.getHeight
  private val width = bi.getWidth
  private val pixels = new ListBuffer[List[RGBPixel]]

  for (h <- 0 until height) {
    val row = new ListBuffer[RGBPixel]
    for (w <- 0 until width) {
      val color = new Color(bi.getRGB(h, w))
      row += RGBPixel(color.getRed, color.getGreen, color.getBlue)
    }
    pixels += row.result()
  }

  def getGrid: RGBGrid = {
    RGBGrid(pixels.result())
  }
}
