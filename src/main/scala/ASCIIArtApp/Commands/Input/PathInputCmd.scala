package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO.ImageIOPathLoader

import scala.util.matching.Regex

case class PathInputCmd(path: String, config: Config) extends Command {
  /**
   * Executes the command
   */
  override def run(): Unit = config.setLoader(new ImageIOPathLoader(path))

}

object PathInputCmd {
  val pattern: Regex = "--image (\\S*)$".r
}
