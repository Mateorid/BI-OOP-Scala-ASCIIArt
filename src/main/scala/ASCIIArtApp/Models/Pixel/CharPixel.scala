package ASCIIArtApp.Models.Pixel

case class CharPixel(char: Char) extends Pixel[Char] {
  override def get(): Char = {
    char
  }
}
