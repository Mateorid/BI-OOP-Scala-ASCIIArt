package ASCIIArtApp.Loaders.RGBImageLoaders

import ASCIIArtApp.Loaders.{ImageLoader, Loader}
import ASCIIArtApp.Models.{Image, PixelGrid, RGBPixel}

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

trait RGBImageLoader extends ImageLoader[RGBPixel] {

  override def load(): Image[RGBPixel]

  protected def biToGrid(bi: BufferedImage): PixelGrid[RGBPixel] = {
    val height = bi.getHeight
    val width = bi.getWidth
    val tmp = ListBuffer.empty[List[RGBPixel]]

    for (h <- 0 until height) {
      val row = new ListBuffer[RGBPixel]
      for (w <- 0 until width)
        row += RGBPixel(new Color(bi.getRGB(w, h)))
      tmp += row.result()
    }
    val pixels = tmp.result()
    new PixelGrid[RGBPixel](pixels)
  }
}
