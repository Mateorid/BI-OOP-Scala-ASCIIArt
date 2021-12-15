package ASCIIArtApp.Commands

trait Command[T] {

  def run(command: T): Unit


}
