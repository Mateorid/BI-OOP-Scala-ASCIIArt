//package ASCIIArtApp.Models.Image
//
//
//class CharImage(val pixelGrid: CharGrid) extends Image {
//
//  def print:Unit = {
//    val height = pixelGrid.pixelRows.length
//    val width = pixelGrid.pixelRows.head.length
//
//    for (h <- 0 until height) {
//      var line: String = ""
//      for (w <- 0 until width) {
//        val c = pixelGrid.pixelRows(h)(w).char
//        line += c
//      }
//      println(line)
//    }
//  }
//
//}
