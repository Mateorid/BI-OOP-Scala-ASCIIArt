package ASCIIArtApp.Loaders

trait Loader {

  /**
   * Loads something somewhere
   * @param item item to be loaded
   */
  def load(): Any
}
