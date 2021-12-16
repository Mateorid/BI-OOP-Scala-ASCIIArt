package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{CharPixel, GSPixel}

object GSToASCIITransformer extends PixelTransformer[GSPixel, CharPixel] {
  private val charRamp =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override def applyOnPixel(pixel: GSPixel): CharPixel = {
    val char = charRamp.charAt((charRamp.length - 1) * pixel.value / 255)
    CharPixel(char)
  }
}
