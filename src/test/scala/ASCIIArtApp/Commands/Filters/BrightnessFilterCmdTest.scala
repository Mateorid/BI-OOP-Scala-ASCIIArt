package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.BrightnessFilter
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock


class BrightnessFilterCmdTest extends FunSuite {
  test(".run test - mockito") {
    val cnf = mock[Config]
    BrightnessFilterCmd(90, cnf).run()
    val captor = ArgumentCaptor.forClass(classOf[BrightnessFilter]).asInstanceOf[ArgumentCaptor[BrightnessFilter]]
    verify(cnf).addGSFilter(captor.capture())
    assert(captor.getValue.value == 90)

  }
  test(".run test - dummy") {
    val cnf = new Config
    BrightnessFilterCmd(50, cnf).run()
    assert(cnf.getGSFilters.head.isInstanceOf[BrightnessFilter])
    assert(cnf.getGSFilters.head.asInstanceOf[BrightnessFilter].value == 50)
  }
  //todo regex test?
}
