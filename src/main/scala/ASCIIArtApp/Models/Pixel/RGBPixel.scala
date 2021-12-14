package ASCIIArtApp.Models.Pixel

import java.awt.Color

case class RGBPixel(value: Color) extends Pixel {
  override def get(): Color = value
}
