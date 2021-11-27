import ASCIIArtApp.Models.Pixel.RGBPixel
import ASCIIArtApp.Models.PixelGrid.RGBGrid
import ASCIIArtApp.Exporters.StdOutputExporter
import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Loaders.PathImageLoader

import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.io.{File, IOException}
import java.net.URL
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer


object Main extends App {
  //  for (i <- Main.args)
  //    println(i)

  val loader = new PathImageLoader
  val exporter = new StdOutputExporter

  val bi = loader.load("src/main/scala/TestImages/test.jpg")
  val imgFacade = new ImageFacade(bi)

  //todo
  exporter.export(imgFacade.getGrid.pixelRows.toString())
  exporter.close()
}