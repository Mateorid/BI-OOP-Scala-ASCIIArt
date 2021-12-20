package ASCIIArtApp.Exporters.Adapters

import ASCIIArtApp.Models.{ASCIIPixel, Image}

object ASCIIToStringAdapter extends ExportAdapter[Image[ASCIIPixel], String] {
  override def adapt(img: Image[ASCIIPixel]): String = {
    var res: String = ""
    for (row <- 0 until img.height) {
      for (col <- 0 until img.width)
        res += img.getPixel(row, col).value
      res += "\n"
    }
    res
  }
}
