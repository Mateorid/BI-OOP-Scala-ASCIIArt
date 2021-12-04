package ASCIIArtApp.Loaders

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object PathImageLoader extends ImageLoader {
  /**
   * Loads from source to BufferedImage
   *
   * @param path to the image to be loaded
   * @return buffered image of the image provided
   */
  override def load(path: String): BufferedImage = {
    //todo catch this above and let them try again in finally block?
    ImageIO.read(new File(path))
  }
}