package ASCIIArtApp.Exporters

import java.io.OutputStream

class StreamTextExporter(outputStream: OutputStream) extends TextExporter {

  /**
   * Exports to provided stream
   * @param text text to be exported
   */
  protected def exportToStream(text: String): Unit = {
    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
    outputStream.close()
  }

  override def export(item: String): Unit = exportToStream(item)
}
