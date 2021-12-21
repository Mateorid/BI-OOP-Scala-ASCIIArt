package ASCIIArtApp.Transformers

trait Transformer[T, Y] {
  /**
   * Transforms an item into another item
   * @param item item to be transformed
   * @return transformed item
   */
  def apply(item: T): Y
}
