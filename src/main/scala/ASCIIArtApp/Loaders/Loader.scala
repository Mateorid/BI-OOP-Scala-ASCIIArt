package ASCIIArtApp.Loaders

trait Loader[T] {

  def load(): T
}
