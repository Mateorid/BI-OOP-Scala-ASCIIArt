package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel
import ASCIIArtApp.Models.PixelGrid

import java.awt.Color
import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

trait RGBImageLoader extends Loader {

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
