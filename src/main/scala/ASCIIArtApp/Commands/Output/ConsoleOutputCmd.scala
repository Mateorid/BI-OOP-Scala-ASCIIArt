package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.StdOutputExporter

import scala.util.matching.Regex

case class ConsoleOutputCmd(config: Config) extends Command {
  /**
   * Executes the command
   */
  override def run(): Unit = config.addExporter(StdOutputExporter)

}

object ConsoleOutputCmd {
  val pattern: Regex = "--output-console$".r
}
