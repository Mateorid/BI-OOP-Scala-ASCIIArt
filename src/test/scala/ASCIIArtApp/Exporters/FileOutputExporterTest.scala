package ASCIIArtApp.Exporters

import Helpers.TestWithFiles
import org.scalatest.FunSuite

import java.io.File

class FileOutputExporterTest extends FunSuite with TestWithFiles {

  test("No file exists") {
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Zdravim vsechny minecraftakuy a minecraftacky!")

      assertFileContent(fileName, "Zdravim vsechny minecraftakuy a minecraftacky!")
    }
    finally {
      ensureDeleted(fileName)
    }
  }

  test("File already exists") {
    val fileName = getTestFile

    try {
      ensureCreated(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Bottom text")

      assertFileContent(fileName, "Bottom text")
    }
    finally {
      ensureDeleted(fileName)
    }
  }

}
