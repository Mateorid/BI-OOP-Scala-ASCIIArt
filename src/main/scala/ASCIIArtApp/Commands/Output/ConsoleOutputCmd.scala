package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.StdOutputExporter

import scala.util.matching.Regex

case class ConsoleOutputCmd(config: Config) extends Command {

  override def run(): Unit = config.exporters = config.exporters :+ StdOutputExporter

}

object ConsoleOutputCmd {
  val pattern: Regex = "--output-console$".r
}
