package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.BrightnessFilter
import org.scalatest.FunSuite

class BrightnessFilterCmdTest extends FunSuite{
  test(".run test") {
    val cnf = new Config //its just a wrapper class no need to mock it right?
    BrightnessFilterCmd(90, cnf).run()
    assert(cnf.gsFilters.head.isInstanceOf[BrightnessFilter])
    assert(cnf.gsFilters.head.asInstanceOf[BrightnessFilter].value == 90)
  }
  //todo regex test?
}
