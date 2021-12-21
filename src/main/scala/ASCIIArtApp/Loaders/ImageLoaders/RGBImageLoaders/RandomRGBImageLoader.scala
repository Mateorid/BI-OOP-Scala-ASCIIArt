package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders

import ASCIIArtApp.Models.{Image, PixelGrid, RGBPixel}

import java.awt.Color

case class RandomRGBImageLoader(height: Int, width: Int) extends RGBImageLoader {
  private val rnd = new scala.util.Random

  /**
   * Creates and loads an Image[RGBPixel]
   *  @return Loaded image
   */
  override def load(): Image[RGBPixel] = new Image[RGBPixel](createGrid)

  /**
   * Creates pixel grid and fills it with random RGBPixels
   * @return PixelGrid[RGBPixel] filled with random RGBPixels
   */
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

  /**
   * @return randomly generated pixel
   */
  private def randomPixel: RGBPixel =
    RGBPixel(new Color(getRandom, getRandom, getRandom))

  /**
   * @return random number between 0 & 255
   */
  private def getRandom: Int = {
    val end = 255
    rnd.nextInt(end + 1)
  }

}
