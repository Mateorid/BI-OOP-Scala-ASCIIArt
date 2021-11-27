package ASCIIArtApp.Loaders

trait Loader[T] {

  /**
   * Loads something somewhere
   * @param item item to be loaded
   */
  def load(item: T): Any
}
