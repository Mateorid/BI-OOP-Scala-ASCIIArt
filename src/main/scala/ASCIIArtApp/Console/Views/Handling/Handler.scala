package ASCIIArtApp.Console.Views.Handling

import scala.annotation.tailrec

trait Handler[T]
{
  /**
   * Handles an items and may return another handler
   * @param item An item to process
   * @return
   */
  def handle(item: T): Option[Handler[T]]

  /**
   * Sets a next handler
   * @param nextHandler The next handler
   * @return The next handler
   */
  def setNext(nextHandler: Handler[T]): Handler[T]
}


object Handler{

  /**
   * Resolves all handler in the chain
   * @param initialHandler The initial handler
   * @tparam T Type of the handler chain
   */
  def resolveAll[T](initialHandler: Handler[T], value: T): Unit = {

    //Loop in handlers
    @tailrec
    def handlerLoop(currentHandler: Handler[T]): Unit = {
      currentHandler.handle(value) match {
        case Some(nextHandler) => handlerLoop(nextHandler)
        case None =>
      }
    }

    handlerLoop(initialHandler)
  }
}

