package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Models.RGBPixel
import ASCIIArtApp.Transformers.Filters.RotateImageFilter

import scala.util.matching.Regex

case class RotateFilterCmd(degrees: Int, config: Config) extends Command {

  override def run(): Unit = config.addRGBFilter(new RotateImageFilter[RGBPixel](degrees))

}

object RotateFilterCmd {
  val pattern: Regex = "--rotate (-?\\d+)$".r
}
