package ASCIIArtApp.Loaders.RGBImageLoaders

import ASCIIArtApp.Models.{Image, RGBPixel}
import com.sun.jdi.InvalidTypeException

import java.io.File
import java.lang.Exception
import javax.imageio.{IIOException, ImageIO}

class PathRGBImageLoader(path: String) extends RGBImageLoader {
  private val supportedTypes = List[String](".jpg", ".png", ".gif")

  override def load(): Image[RGBPixel] = {
    try {
      val grid = biToGrid(ImageIO.read(makeFile))
      new Image[RGBPixel](grid)
    } catch {
      case _: IIOException => throw new IllegalArgumentException("--ERROR--\nFailed to load the path, check if the path is correct and the file exists!")
    }
  }

  private def makeFile: File = {
    for (i <- supportedTypes) {
      if (path.endsWith(i)) {
        return new File(path)
      }
    }
    throw new InvalidTypeException("--ERROR--\nInvalid file type!\nFile must be:\n" + printSupported)
  }

  private def printSupported: String = {
    var res = new String
    for (i <- supportedTypes) res += i + "\n"
    res
  }

}
