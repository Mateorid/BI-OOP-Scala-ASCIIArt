package ASCIIArtApp.Facades

import ASCIIArtApp.Models.Image.{CharImage, RGBImage}
import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Models.PixelGrid.{CharGrid, RGBGrid}

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

class ImageFacade(bi: BufferedImage) {
  private val height = bi.getHeight
  private val width = bi.getWidth
  private val tmp = ListBuffer.empty[List[RGBPixel]]
  for (h <- 0 until height) {
    val row = new ListBuffer[RGBPixel]
    for (w <- 0 until width) {
      val color = new Color(bi.getRGB(w, h))
      row += RGBPixel(color.getRed, color.getGreen, color.getBlue)
    }
    tmp += row.result()
  }
  val pixels: List[List[RGBPixel]] = tmp.result()
  private val rgbImage = new RGBImage(RGBGrid(pixels))

//todo  def applyFilters(filters:List[Filter])

  def transform(): CharImage = {
    val res = ListBuffer.empty[List[GSPixel]]
    for (h <- 0 until height) {
      val row = ListBuffer.empty[GSPixel]
      for (w <- 0 until width) {
        val rgb = pixels(h)(w).get()
        val gsVal = (0.3 * rgb._1) + (0.59 * rgb._2) + (0.11 * rgb._3)
        val pixel = GSPixel(gsVal.toInt)
        row += pixel
      }
      res += row.result()
    }
    val gsGrid = res.result()

    val charRamp =
      "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

    val tmpChars = ListBuffer.empty[List[CharPixel]]
    for (h <- 0 until height) {
      val row = ListBuffer.empty[CharPixel]
      for (w <- 0 until width) {
        val pixel = CharPixel(
          charRamp.charAt((charRamp.length - 1) * gsGrid(h)(w).get() / 255))
        row += pixel
      }
      tmpChars += row.result()
    }
    val cg = CharGrid(tmpChars.result())
   new CharImage(cg)
  }
}
