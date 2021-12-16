package ASCIIArtApp.Exporters.Adapters

trait ExportAdapter[T, U] {
  def adapt(original: T): U
}
