package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.InvertImageFilter
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class InvertFilterCmdTest extends FunSuite {
  test(".run test - mock") {
    val cnf = mock[Config]
    InvertFilterCmd(cnf).run()
    verify(cnf).addGSFilter(InvertImageFilter)
  }
  test(".run test - dummy") {
    val cnf = new Config
    InvertFilterCmd(cnf).run()
    assert(cnf.getGSFilters.contains(InvertImageFilter))
  }
  //todo regex test?
}
