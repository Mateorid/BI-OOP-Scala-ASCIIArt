package ASCIIArtApp.Loaders

import java.awt.image.BufferedImage

trait ImageLoader[T] extends Loader[T] {

  /**
   * Loads from source to BufferedImage
   * @param imageSource item to be loaded
   * @return buffered image of the image provided
   */
  def load(imageSource: T): BufferedImage
}
