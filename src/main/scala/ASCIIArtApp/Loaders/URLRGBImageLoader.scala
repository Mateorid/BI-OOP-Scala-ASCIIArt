package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel

import java.net.URL
import javax.imageio.ImageIO

class URLRGBImageLoader(url: String) extends RGBImageLoader {

  override def load(): Image[RGBPixel] = {
    val grid = biToGrid(ImageIO.read(new URL(url)))
    new Image[RGBPixel](grid)
  }
}
