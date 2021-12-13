package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, RGBPixel}

class RGBToGSFilter extends PixelFilter[RGBPixel, GSPixel] {
  override protected def applyOnPixel(pixel: RGBPixel): GSPixel = {
    val rgb = pixel.get()
    val gs = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    GSPixel(gs.toInt)
  }

}
