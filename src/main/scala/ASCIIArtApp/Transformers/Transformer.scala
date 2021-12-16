package ASCIIArtApp.Transformers

trait Transformer[T, Y] {
  def apply(item: T): Y
}
