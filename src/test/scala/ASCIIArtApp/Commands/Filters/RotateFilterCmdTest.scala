package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Models.RGBPixel
import ASCIIArtApp.Transformers.Filters.RotateImageFilter
import org.scalatest.FunSuite

class RotateFilterCmdTest extends FunSuite {
  test(".run test") {
    val cnf = new Config //its just a wrapper class no need to mock it right?
    RotateFilterCmd(90, cnf).run()
    assert(cnf.rgbFilters.head.isInstanceOf[RotateImageFilter[RGBPixel]])
    assert(cnf.rgbFilters.head.asInstanceOf[RotateImageFilter[RGBPixel]].degrees == 90)
  }
  //todo regex test?
}
