package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.StdOutputExporter
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class ConsoleOutputCmdTest extends FunSuite {
  test(".run test - mockito") {
    val cnf = mock[Config]
    ConsoleOutputCmd(cnf).run()
    verify(cnf).addExporter(StdOutputExporter)
  }
  test(".run test - dummy") {
    val cnf = new Config
    ConsoleOutputCmd(cnf).run()
    assert(cnf.getExporters.contains(StdOutputExporter))
  }
  //todo regex test?
}
