package ASCIIArtApp.Loaders

import java.awt.image.BufferedImage
import java.net.URL
import javax.imageio.ImageIO

class URLImageLoader extends ImageLoader[String] {
  /**
   * Loads from source to BufferedImage
   *
   * @param url to the image to be loaded
   * @return buffered image of the image provided
   */
  override def load(url: String): BufferedImage = {
    //todo catch this above and let them try again in finally block?
    ImageIO.read(new URL(url))
  }
}
