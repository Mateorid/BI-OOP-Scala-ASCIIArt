package ASCIIArtApp.Models.Pixel

trait Pixel {
  val value: Any
//  def get(): _
  def print(): String = value.toString
}
