package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel

object RandomImageLoader extends ImageLoader {

  /**
   * Loads from source to BufferedImage
   *
   * @param imageSource item to be loaded
   * @return buffered image of the image provided
   */
  override def load(imageSource: String): Image[RGBPixel] = {
    //todo
    null
  }
}
