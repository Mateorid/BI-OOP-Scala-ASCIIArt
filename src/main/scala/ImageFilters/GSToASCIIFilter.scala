package ImageFilters

import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel}

object GSToASCIIFilter extends PixelFilter[GSPixel, CharPixel] {
  private val charRamp =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override protected def applyOnPixel(pixel: GSPixel): CharPixel = {
    val char = charRamp.charAt((charRamp.length - 1) * pixel.get() / 255)
    CharPixel(char)
  }
}
