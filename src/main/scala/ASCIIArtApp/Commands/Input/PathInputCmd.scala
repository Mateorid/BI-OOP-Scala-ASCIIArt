package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.PathRGBImageLoader

import scala.util.matching.Regex

case class PathInputCmd(path: String, config: Config) extends InputCommand(config) {

  //  override def run(): Unit = {
  //    if (config.loader == null)
  //      config.loader = new PathRGBImageLoader(path)
  //    else
  //      throw new IllegalArgumentException("There can only be 1 image input!")
  //  }

  override protected def addLoader(): Unit = config.loader = new PathRGBImageLoader(path)

}

object PathInputCmd {
  val pattern: Regex = "--image (\\S*)$".r
}
