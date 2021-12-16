package ASCIIArtApp.UI

trait InputHandler[T] {
  def handleInput(input: T): Unit
}
