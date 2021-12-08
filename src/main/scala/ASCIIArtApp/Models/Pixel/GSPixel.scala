package ASCIIArtApp.Models.Pixel

case class GSPixel (gsVal: Int) extends Pixel[Int] {

  override def get(): Int = {
    gsVal
  }
}
