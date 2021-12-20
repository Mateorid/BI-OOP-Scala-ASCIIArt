package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Transformers.Filters.GSFilters.InvertImageFilter
import org.scalatest.FunSuite

class InvertFilterCmdTest extends FunSuite {

  test(".run test"){
    val cnf = new Config //its just a wrapper class no need to mock it right?
    InvertFilterCmd(cnf).run()
    assert(cnf.gsFilters.contains(InvertImageFilter))
  }
  //todo regex test?
}
