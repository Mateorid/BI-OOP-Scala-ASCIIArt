package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel

import java.net.URL
import javax.imageio.ImageIO

object URLImageLoader extends ImageLoader {
  /**
   * Loads from source to BufferedImage
   *
   * @param url to the image to be loaded
   * @return buffered image of the image provided
   */
  override def load(url: String): Image[RGBPixel] = {
    val grid = biToGrid(ImageIO.read(new URL(url)))
    new Image[RGBPixel](grid)
  }
}
