package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.URLRGBImageLoader

import scala.util.matching.Regex

case class URLInputCmd(path: String, config: Config) extends InputCommand(config) {
//
//  override def run(): Unit = {
//    if (config.loader == null)
//      config.loader = new URLRGBImageLoader(path)
//    else
//      throw new IllegalArgumentException("There can only be 1 image input!")
//  }

  override protected def addLoader(): Unit = config.loader = new URLRGBImageLoader(path)

}

object URLInputCmd {
  val pattern: Regex = "--image-url (...\\S*)".r
}
