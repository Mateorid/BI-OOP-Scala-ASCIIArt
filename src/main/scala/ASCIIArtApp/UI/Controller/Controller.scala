package ASCIIArtApp.UI.Controller

trait Controller[T, Y, U] {
  protected var loader: T = _
  protected var exporter: Y = _
  protected var filters = List.empty[U]

  def setInput(in: T): Unit = loader = in

  def setOutput(out: Y): Unit = exporter = out

  def addFilter(filter: U): Unit = filters = filters :+ filter

  def executeCommands(): Unit

  def export(): Unit

  //todo add comments
}
