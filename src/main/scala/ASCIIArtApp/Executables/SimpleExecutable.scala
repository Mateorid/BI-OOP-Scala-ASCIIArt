package ASCIIArtApp.Executables

class SimpleExecutable[T] extends Executable[T] {

  var nextEx: Option[Executable[T]] = None

  override def execute(item: T): Option[Executable[T]] = nextEx

  override def setNext(next: Executable[T]): Executable[T] = {
    this.nextEx = Some(next)
    next
  }
}

object SimpleExecutable {
  def empty(): SimpleExecutable[Nothing] = new SimpleExecutable[Nothing]
}
