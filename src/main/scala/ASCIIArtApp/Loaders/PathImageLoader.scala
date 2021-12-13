package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel

import java.io.File
import javax.imageio.ImageIO

object PathImageLoader extends ImageLoader {
  /**
   * Loads from source to BufferedImage
   *
   * @param path to the image to be loaded
   * @return buffered image of the image provided
   */
  override def load(path: String): Image[RGBPixel] = {
    val grid = biToGrid(ImageIO.read(new File(path)))
    new Image[RGBPixel](grid)
  }
}
