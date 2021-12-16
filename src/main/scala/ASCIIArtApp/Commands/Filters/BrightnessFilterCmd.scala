package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.BrightnessFilter

import scala.util.matching.Regex

case class BrightnessFilterCmd(value: Int, config: Config) extends Command {
  override def run(): Unit =
    config.gsFilters = config.gsFilters :+ new BrightnessFilter(value)
}

object BrightnessFilterCmd {
  val pattern: Regex = "--brightness (-?\\d+)$".r
}
