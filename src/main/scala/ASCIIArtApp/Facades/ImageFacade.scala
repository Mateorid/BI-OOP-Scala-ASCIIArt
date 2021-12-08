package ASCIIArtApp.Facades

import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Models.PixelGrid
import ImageFilters.ImageFilter

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

class ImageFacade(bi: BufferedImage) {
  private val height = bi.getHeight
  private val width = bi.getWidth
  private val tmp = ListBuffer.empty[List[RGBPixel]]

  for (h <- 0 until height) {
    val row = new ListBuffer[RGBPixel]
    for (w <- 0 until width)
//      val color = new Color(bi.getRGB(w, h))
      row += RGBPixel(new Color(bi.getRGB(w, h)))
    tmp += row.result()
  }
  private val pixels = tmp.result()
  private val rgbImg = new PixelGrid[RGBPixel](pixels)
  private var gsImg: PixelGrid[GSPixel] = _
  private var asciiImg: PixelGrid[CharPixel] = _

  def applyFilters(filters: List[ImageFilter]): Unit = {
    gsImg = toGrayScale
    for (i <- filters)
      gsImg = i.apply(gsImg)
  }

  def transformToASCII(): Unit = {
    val charRamp =
      "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

    val tmpChars = ListBuffer.empty[List[CharPixel]]
    for (h <- 0 until height) {
      val row = ListBuffer.empty[CharPixel]
      for (w <- 0 until width) {
        val pixel = CharPixel(
          charRamp.charAt(
            (charRamp.length - 1) * gsImg.getPixels(h)(w).get() / 255))
        row += pixel
      }
      tmpChars += row.result()
    }
    asciiImg = new PixelGrid[CharPixel](tmpChars.result())
  }

  override def toString: String =
    asciiImg.print

  private def toGrayScale: PixelGrid[GSPixel] = {
    val res = ListBuffer.empty[List[GSPixel]]
    for (h <- 0 until height) {
      val row = ListBuffer.empty[GSPixel]
      for (w <- 0 until width) {
        val rgb = pixels(h)(w).get()
        val gsVal = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
        val pixel = GSPixel(gsVal.toInt)
        row += pixel
      }
      res += row.result()
    }
    new PixelGrid[GSPixel](res.result())
  }
}
