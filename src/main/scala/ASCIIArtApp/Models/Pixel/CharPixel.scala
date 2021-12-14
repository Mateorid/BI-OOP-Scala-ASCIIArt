package ASCIIArtApp.Models.Pixel

case class CharPixel(value: Char) extends Pixel {

  override def get(): Char = value
}
