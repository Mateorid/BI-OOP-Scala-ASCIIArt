package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.GSPixel
import ASCIIArtApp.Transformers.Filters.PixelFilter

/**
 * Changes the brightness of the picture
 *
 * @param value value to change the brightness by, must be between -255 & +255
 */
class BrightnessFilter(val value: Int) extends PixelFilter[GSPixel] {
  if (value < -255 || value > 255)
    throw new IllegalArgumentException("--ERROR--\nBrightness value must be between -255 & +255")


  /**
   * Changes the brightness value of the pixel
   *
   * @param pixel pixel to change brightness
   * @return pixel with changed brightness
   */
  override def applyOnPixel(pixel: GSPixel): GSPixel = {
    if (value == 0)
      return pixel
    var res: Int = pixel.value + value
    if (res > 255) res = 255
    if (res < 0) res = 0
    GSPixel(res)
  }
}
