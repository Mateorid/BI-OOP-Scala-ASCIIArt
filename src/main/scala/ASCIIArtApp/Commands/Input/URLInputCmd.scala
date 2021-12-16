package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.URLRGBImageLoader

import scala.util.matching.Regex

case class URLInputCmd(path: String, config: Config) extends Command {
  override def run(): Unit = config.loader = new URLRGBImageLoader(path)
}

object URLInputCmd {
  val pattern: Regex = "--image-url (...\\S*)".r
}
