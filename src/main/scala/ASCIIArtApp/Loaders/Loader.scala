package ASCIIArtApp.Loaders

trait Loader[T] {
  /**
   * Loads something
   * @return Loaded item
   */
  def load(): T
}
