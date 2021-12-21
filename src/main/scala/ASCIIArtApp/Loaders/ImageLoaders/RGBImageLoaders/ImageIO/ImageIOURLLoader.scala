package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO

import ASCIIArtApp.Models.{Image, RGBPixel}

import java.net.{MalformedURLException, URL}
import javax.imageio.{IIOException, ImageIO}

case class ImageIOURLLoader(url: String) extends ImageIOLoader[URL] {

  /**
   * @return Loaded Image[RGBPixel]
   */

  override def load(): Image[RGBPixel] = {
    try {
      val bi = ImageIO.read(new URL(url))
      new Image[RGBPixel](biToGrid(bi))
    } catch {
      case _: IIOException => throw new IllegalArgumentException("--ERROR--\nFailed to load image from the URL! Please check is the URL is correct.")
      case _: MalformedURLException => throw new IllegalArgumentException("--ERROR--\nFailed to load image from the URL! Please check is the URL is correct.")
    }
  }
}
