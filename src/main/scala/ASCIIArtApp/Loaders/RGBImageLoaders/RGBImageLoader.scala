package ASCIIArtApp.Loaders.RGBImageLoaders

import ASCIIArtApp.Loaders.Loader
import ASCIIArtApp.Models.{Image, PixelGrid, RGBPixel}

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

trait RGBImageLoader extends Loader[Image[RGBPixel]] {

  override def load(): Image[RGBPixel]

  protected def biToGrid(bufferedImage: BufferedImage): PixelGrid[RGBPixel] = {
    //todo check and throw exceptions
    val height = bufferedImage.getHeight
    val width = bufferedImage.getWidth
    val tmp = ListBuffer.empty[List[RGBPixel]]

    for (h <- 0 until height) {
      val row = new ListBuffer[RGBPixel]
      for (w <- 0 until width)
        row += RGBPixel(new Color(bufferedImage.getRGB(w, h)))
      tmp += row.result()
    }
    val pixels = tmp.result()
    new PixelGrid[RGBPixel](pixels)
  }
}
