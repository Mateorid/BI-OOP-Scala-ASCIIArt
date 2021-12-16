package ASCIIArtApp.Loaders.RGBImageLoaders

import ASCIIArtApp.Models.{Image, RGBPixel}

import java.net.URL
import javax.imageio.ImageIO

class URLRGBImageLoader(url: String) extends RGBImageLoader {

  override def load(): Image[RGBPixel] = {
    val grid = biToGrid(ImageIO.read(new URL(url)))
    new Image[RGBPixel](grid)
  }
}
