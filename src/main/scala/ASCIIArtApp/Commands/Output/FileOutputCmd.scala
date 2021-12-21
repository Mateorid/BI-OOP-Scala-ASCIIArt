package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Commands.Command
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.FileOutputExporter

import java.io.File
import scala.util.matching.Regex

case class FileOutputCmd(path: String, config: Config) extends Command() {
  /**
   * Executes the command
   */
  override def run(): Unit = config.addExporter(new FileOutputExporter(new File(path)))

}

object FileOutputCmd {
  val pattern: Regex = "--output-file (\\S+)$".r
}
