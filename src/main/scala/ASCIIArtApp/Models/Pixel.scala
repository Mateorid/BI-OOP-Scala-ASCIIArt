package ASCIIArtApp.Models

import java.awt.Color

trait Pixel {}

case class CharPixel(value: Char) extends Pixel {} //No need to check, char cant be empty or null :)

case class RGBPixel(value: Color) extends Pixel {
  if (value == null) {
    throw new IllegalArgumentException("--ERROR--\nRGBPixel color cannot be null!")
  }
}

case class GSPixel(value: Int) extends Pixel {
  if (value < 0 || value > 255)
    throw new IllegalArgumentException("--ERROR--\nGS value must be between 0 and 255!")
}
