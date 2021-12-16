package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.PathRGBImageLoader

import scala.util.matching.Regex

case class PathInputCmd(path: String, config: Config) extends Command {

  override def run(): Unit = config.loader = new PathRGBImageLoader(path)

}

object PathInputCmd {
  val pattern: Regex = "--image (\\S*)$".r
}
