import ASCIIArtApp.Models.PixelGrid.RGBGrid

import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO





object Main extends App {
  //  for (i <- Main.args)
  //    println(i)
  def printPixelARGB(pixel: Int): Unit = {
    val alpha = (pixel >> 24) & 0xff
    val red = (pixel >> 16) & 0xff
    val green = (pixel >> 8) & 0xff
    val blue = pixel & 0xff
    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue)
  }

  try {
    val bufferedImage = ImageIO.read(new URL("https://cdn.sstatic.net/Sites/stackoverflow/Img/apple-touch-icon.png?v=c78bd457575a"))

    //  val bufferedImage = ImageIO.read(PerformanceTest.getResource("12000X120.jpg"))
    val x = bufferedImage.getWidth
    val y = bufferedImage.getHeight
    val hasAlpha = bufferedImage.getAlphaRaster != null

    var pixels = Array.ofDim[Int](y, x)
    var i = 0
    var j = 0
    if (hasAlpha) {
      for (i <- 0 until y) {
        for (j <- 0 until x) {
          println("x = " + j + " y = " + i + " --> "+ bufferedImage.getRGB(j, i))
//          printPixelARGB(bufferedImage.getRGB(i, j))
        }

      }
    }
    else {
      println("POGEGA")
    }

    println("XD")


  }

  catch {
    case e: IOException =>
      e.printStackTrace()
  }
}