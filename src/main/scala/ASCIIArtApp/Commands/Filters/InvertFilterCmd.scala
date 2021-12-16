package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.InvertImageFilter

import scala.util.matching.Regex

case class InvertFilterCmd(config: Config) extends Command {
  override def run(): Unit =
    config.gsFilters = config.gsFilters :+ InvertImageFilter
}

object InvertFilterCmd {
  val pattern: Regex = "--invert$".r
}
