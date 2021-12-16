package ASCIIArtApp.Models

import java.awt.Color

trait Pixel {}

case class GSPixel(value: Int) extends Pixel {}

case class CharPixel(value: Char) extends Pixel {}

case class RGBPixel(value: Color) extends Pixel {}
