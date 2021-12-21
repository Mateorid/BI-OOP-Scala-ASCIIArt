package ASCIIArtApp.Exporters

import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

class StreamTextExporterTest extends FunSuite {
  test("OK export") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }
  test("Empty export") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("")

    assert(stream.toString("UTF-8") == "")
  }
}
