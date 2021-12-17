package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.RandomRGBImageLoader

import scala.util.matching.Regex

case class RandomInputCmd(height: Int, width: Int, config: Config) extends InputCommand(config) {

  //  override def run(): Unit = {
  //    if (config.loader == null)
  //      config.loader = new RandomRGBImageLoader(height, width)
  //    else
  //      throw new IllegalArgumentException("There can only be 1 image input!")
  //  }

  override protected def addLoader(): Unit = config.loader = new RandomRGBImageLoader(height, width)
}

object RandomInputCmd {
  val pattern: Regex = "--image-random (\\d+) (\\d+)$".r
}
