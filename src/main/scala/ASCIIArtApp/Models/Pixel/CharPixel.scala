package ASCIIArtApp.Models.Pixel

case class CharPixel(char: Char) extends Pixel {
  override def get(): Char = {
    char
  }
}
