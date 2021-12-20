package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.FileOutputExporter
import org.scalatest.FunSuite

class FileOutputCmdTest extends FunSuite {
  test(".run test") {
    val cnf = new Config //its just a wrapper class no need to mock it right?
    val path = "src\\main\\scala\\TestImages\\xd.txt"
    FileOutputCmd(path, cnf).run()
    assert(cnf.exporters.head.isInstanceOf[FileOutputExporter])
    assert(cnf.exporters.head.asInstanceOf[FileOutputExporter].file.getPath == path)
  }
  //todo regex test?
}
