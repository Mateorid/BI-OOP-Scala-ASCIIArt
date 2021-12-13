package ASCIIArtApp.UI.InputHandlers

trait InputHandler[T] {
  def handleInput(input: T): Unit
}
