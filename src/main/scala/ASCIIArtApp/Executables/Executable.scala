package ASCIIArtApp.Executables

import scala.annotation.tailrec

trait Executable[T] {

  def execute(item: T): Option[Executable[T]]

  def setNext(next: Executable[T]): Executable[T]
}

object Executable {

  def executeAll[T](initialEx: Executable[T], value: T): Unit = {

    @tailrec
    def handlerLoop(currentHandler: Executable[T]): Unit =
      currentHandler.execute(value) match {
        case Some(nextHandler) => handlerLoop(nextHandler)
        case None              =>
      }
    handlerLoop(initialEx)
  }
}
