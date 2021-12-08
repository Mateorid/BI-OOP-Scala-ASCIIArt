package ASCIIArtApp.Facades

import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Models.PixelGrid.{CharGrid, GSGrid, PixelGrid, RGBGrid}
import ImageFilters.{ImageFilter, PixelFilter}

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

class ImageFacade(bi: BufferedImage) {
  private var rgbImg: RGBGrid = _
  private var gsImg: GSGrid = _
  private var asciiImg: CharGrid = _
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
  private val pixels = tmp.result()
  rgbImg = RGBGrid(pixels)

//  def applyFilters(filters: List[PixelFilter], gridFilters: List[PixelGridFilter]): Unit = {
  def applyFilters(filters: Seq[ImageFilter[GSGrid]]): Unit = {
    //todo create some filter executor/handler/controller class?
    gsImg = toGrayScale
    for (i <- filters)
      gsImg = i.apply(gsImg)

//    for (i <- gridFilters)
//      gsImg = i.apply(gsImg)
//    for (i <- filters)
//      gsImg = gsImg.applyFilterOnPixel(i.apply)
  }

  def transform(): Unit = {
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
    asciiImg = CharGrid(tmpChars.result())
  }

  override def toString: String =
    asciiImg.print

  private def toGrayScale: GSGrid = {
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
    new GSGrid(res.result())
  }
}
