package ASCIIArtApp.Loaders.RGBImageLoaders

import ASCIIArtApp.Models.{Image, PixelGrid, RGBPixel}

import java.awt.Color

class RandomRGBImageLoader(val height: Int, val width: Int) extends RGBImageLoader {
  private val rnd = new scala.util.Random

  override def load(): Image[RGBPixel] = new Image[RGBPixel](createGrid)

  private def createGrid: PixelGrid[RGBPixel] = {
    var tmp = Seq.empty[Seq[RGBPixel]]

    for (_ <- 0 until height) {
      var row = Seq.empty[RGBPixel]
      for (_ <- 0 until width)
        row = row.:+(randomPixel)
      tmp = tmp :+ row
    }
    new PixelGrid[RGBPixel](tmp)
  }

  private def randomPixel: RGBPixel =
    RGBPixel(new Color(getRandom, getRandom, getRandom))

  private def getRandom: Int = {
    val end = 255
    rnd.nextInt(end + 1)
  }

}
