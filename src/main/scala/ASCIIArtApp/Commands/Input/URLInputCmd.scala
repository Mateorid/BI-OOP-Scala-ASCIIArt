package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO.ImageIOURLLoader

import scala.util.matching.Regex

case class URLInputCmd(path: String, config: Config) extends Command {
  /**
   * Executes the command
   */
  override def run(): Unit = config.setLoader(ImageIOURLLoader(path))

}

object URLInputCmd {
  val pattern: Regex = "--image-url (...\\S*)".r
}
