package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO

import ASCIIArtApp.Models.{Image, RGBPixel}

import java.io.File
import javax.imageio.{IIOException, ImageIO}

class ImageIOPathLoader(val path: String) extends ImageIOLoader[File] {
  protected val supportedTypes: Seq[String] = Seq[String](".jpg", ".png", ".gif")

  override def load(): Image[RGBPixel] = {
    try {
      val bi = ImageIO.read(makeFile(path))
      new Image[RGBPixel](biToGrid(bi))
    } catch {
      case _: IIOException => throw new IllegalArgumentException("--ERROR--\nFailed to load the path, check if the path is correct and the file exists!")
    }
  }

  protected def makeFile(path: String): File = {
    for (i <- supportedTypes) {
      if (path.endsWith(i)) {
        return new File(path)
      }
    }
    throw new IllegalArgumentException("--ERROR--\nInvalid file type!\nFile must be:\n" + printSupported)
  }

  protected def printSupported: String = {
    var res = new String
    for (i <- supportedTypes) res += i + "\n"
    res
  }
}
