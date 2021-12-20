package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{ASCIIPixel, GSPixel}

object GSToASCIITransformer extends PixelTransformer[GSPixel, ASCIIPixel] {
  private val charRamp =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override protected def applyOnPixel(pixel: GSPixel): ASCIIPixel = {
    val char = charRamp.charAt((charRamp.length - 1) * pixel.value / 255)
    ASCIIPixel(char)
  }
}
