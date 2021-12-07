package ASCIIArtApp.Loaders

import java.awt.image.BufferedImage
import java.net.URL
import javax.imageio.ImageIO

object URLImageLoader extends ImageLoader {
  /**
   * Loads from source to BufferedImage
   *
   * @param url to the image to be loaded
   * @return buffered image of the image provided
   */
  override def load(url: String): BufferedImage = {
    ImageIO.read(new URL(url))
  }
}
