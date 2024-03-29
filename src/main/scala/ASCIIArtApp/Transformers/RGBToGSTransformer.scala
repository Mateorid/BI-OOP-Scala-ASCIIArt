package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{GSPixel, RGBPixel}

object RGBToGSTransformer extends PixelTransformer[RGBPixel, GSPixel] {
  /**
   * Transforms RGBPixel into GSPixel
   *
   * @param pixel pixel to be transformed
   * @return transformed pixel
   */
  override protected def applyOnPixel(pixel: RGBPixel): GSPixel = {
    val rgb = pixel.value
    val gs = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    GSPixel(gs.toInt)
  }
}
