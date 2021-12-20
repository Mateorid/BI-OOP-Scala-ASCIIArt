package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.StdOutputExporter
import org.scalatest.FunSuite

class ConsoleOutputCmdTest extends FunSuite {
  test(".run test") {
    val cnf = new Config //its just a wrapper class no need to mock it right?
    ConsoleOutputCmd(cnf).run()
    assert(cnf.exporters.contains(StdOutputExporter))
  }
  //todo regex test?
}
