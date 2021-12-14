package ASCIIArtApp.Models.Pixel

case class GSPixel(value: Int) extends Pixel {

  override def get(): Int = value
}
