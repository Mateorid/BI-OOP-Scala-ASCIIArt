package ASCIIArtApp.Models.Pixel

case class GSPixel (gsVal: Int) extends Pixel {
  override def get(): Int = {
    gsVal
  }
}
