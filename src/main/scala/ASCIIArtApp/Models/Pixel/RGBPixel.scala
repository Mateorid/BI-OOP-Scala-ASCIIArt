package ASCIIArtApp.Models.Pixel

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {
  //todo some internal check if the pixels have valued of <0,256> - or in some business logic

  def get(): (Int, Int, Int) = {
    (red, green, blue)
  }
}
