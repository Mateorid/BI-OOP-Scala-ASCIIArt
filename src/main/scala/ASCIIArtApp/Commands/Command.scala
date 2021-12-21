package ASCIIArtApp.Commands

trait Command {
  /**
   * Executes the command
   */
  def run(): Unit
}
