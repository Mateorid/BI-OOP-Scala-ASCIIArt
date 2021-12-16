package ASCIIArtApp.Exporters.Adapters

import ASCIIArtApp.Models.{CharPixel, Image}

object ASCIIToStringAdapter extends ExportAdapter[Image[CharPixel], String] {
  override def adapt(img: Image[CharPixel]): String = {
    var res: String = ""
    for (row <- 0 until img.height) {
      for (col <- 0 until img.width)
        res += img.getPixel(row, col).value
      res += "\n"
    }
    res
  }
}
