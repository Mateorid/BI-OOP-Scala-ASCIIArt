package ASCIIArtApp.Models.Pixel

case class CharPixel(value: Char) extends Pixel {

  def get(): Char = value
}
