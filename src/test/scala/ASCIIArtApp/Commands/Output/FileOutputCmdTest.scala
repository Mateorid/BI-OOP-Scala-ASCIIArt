package ASCIIArtApp.Commands.Output

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.FileOutputExporter
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class FileOutputCmdTest extends FunSuite {
  val path = "src\\main\\scala\\TestImages\\xd.txt"

  test(".run test - mockito") {
    val cnf = mock[Config]
    FileOutputCmd(path, cnf).run()
    val captor = ArgumentCaptor.forClass(classOf[FileOutputExporter])
      .asInstanceOf[ArgumentCaptor[FileOutputExporter]]

    verify(cnf).addExporter(captor.capture())
    assert(captor.getValue.file.getPath == path)
  }
  test(".run test - dummy") {
    val cnf = new Config
    FileOutputCmd(path, cnf).run()
    assert(cnf.getExporters.head.isInstanceOf[FileOutputExporter])
    assert(cnf.getExporters.head.asInstanceOf[FileOutputExporter].file.getPath == path)
  }
  //todo regex test?
}
