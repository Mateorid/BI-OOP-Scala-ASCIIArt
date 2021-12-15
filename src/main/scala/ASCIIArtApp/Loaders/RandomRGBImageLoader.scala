package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.RGBPixel
import ASCIIArtApp.Models.PixelGrid

import java.awt.Color
import scala.collection.mutable.ListBuffer

object RandomRGBImageLoader extends RGBImageLoader {
  val rnd = new scala.util.Random
  val height = 40
  val width = 80

  override def load(): Image[RGBPixel] = new Image[RGBPixel](createGrid)

  private def createGrid: PixelGrid[RGBPixel] = {
    val tmp = ListBuffer.empty[List[RGBPixel]]

    for (h <- 0 until height) {
      val row = new ListBuffer[RGBPixel]
      for (w <- 0 until width)
        row += randomPixel
      tmp += row.result()
    }
    new PixelGrid[RGBPixel](tmp.result())
  }

  private def randomPixel: RGBPixel =
    RGBPixel(new Color(getRandom, getRandom, getRandom))

  private def getRandom: Int = {
    val end = 255
    rnd.nextInt(end + 1)
  }

}
