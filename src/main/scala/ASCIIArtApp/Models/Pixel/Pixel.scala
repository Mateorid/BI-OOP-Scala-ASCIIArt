package ASCIIArtApp.Models.Pixel

trait Pixel {
  val value: Any
  def get(): Any
  def print(): String = value.toString
}
