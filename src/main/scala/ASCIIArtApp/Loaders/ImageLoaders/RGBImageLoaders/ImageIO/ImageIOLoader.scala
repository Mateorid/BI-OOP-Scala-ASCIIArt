package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO

import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{PixelGrid, RGBPixel}

import java.awt.Color
import java.awt.image.BufferedImage

trait ImageIOLoader[T] extends RGBImageLoader {

  /**
   * Transforms given buffered image into a PixelGrid[RGBPixel]
   * @param bi buffered image
   * @return PixelGrid[RGBPixel] created from buffered image
   */
  protected def biToGrid(bi: BufferedImage): PixelGrid[RGBPixel] = {
    if (bi == null)
      throw new NullPointerException("--ERROR--\nThe input image is null!")
    val height = bi.getHeight
    val width = bi.getWidth
    var tmp = Seq.empty[Seq[RGBPixel]]

    for (h <- 0 until height) {
      var row = Seq.empty[RGBPixel]
      for (w <- 0 until width)
        row = row :+ RGBPixel(new Color(bi.getRGB(w, h)))
      tmp = tmp :+ row
    }
    val pixels = tmp
    new PixelGrid[RGBPixel](pixels)
  }
}
