package ASCIIArtApp.Exporters

import java.io.{File, FileOutputStream}

class FileOutputExporter(val file: File)
  extends StreamTextExporter(new FileOutputStream(file)) {}
