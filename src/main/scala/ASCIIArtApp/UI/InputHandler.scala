package ASCIIArtApp.UI

trait InputHandler[T] {
  /**
   * Handles the provided input
   * @param input to be handled
   */
  def handleInput(input: T): Unit
}
