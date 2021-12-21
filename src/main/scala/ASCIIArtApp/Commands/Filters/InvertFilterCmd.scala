package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.InvertImageFilter

import scala.util.matching.Regex

case class InvertFilterCmd(config: Config) extends Command {
  /**
   * Executes the command
   */
  override def run(): Unit = config.addGSFilter(InvertImageFilter)

}

object InvertFilterCmd {
  val pattern: Regex = "--invert$".r
}
