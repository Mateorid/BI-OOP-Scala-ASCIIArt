package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel

import java.io.File
import javax.imageio.ImageIO

class PathRGBImageLoader(path: String) extends RGBImageLoader {

  override def load(): Image[RGBPixel] = {
    val grid = biToGrid(ImageIO.read(new File(path)))
    new Image[RGBPixel](grid)
  }
}
