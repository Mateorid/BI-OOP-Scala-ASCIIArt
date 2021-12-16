package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.RandomRGBImageLoader

import scala.util.matching.Regex

case class RandomInputCmd(height: Int, width: Int, config: Config)
  extends Command {

  override def run(): Unit =
    config.loader = new RandomRGBImageLoader(height, width)

}

object RandomInputCmd {
  val pattern: Regex = "--image-random (\\d+) (\\d+)$".r
}
