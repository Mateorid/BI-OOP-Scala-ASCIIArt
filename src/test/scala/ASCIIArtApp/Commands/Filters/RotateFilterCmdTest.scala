package ASCIIArtApp.Commands.Filters

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Models.RGBPixel
import ASCIIArtApp.Transformers.Filters.RotateImageFilter
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class RotateFilterCmdTest extends FunSuite {
  test(".run test - mockito") {
    val cnf = mock[Config]
    RotateFilterCmd(180, cnf).run()
    val captor =
      ArgumentCaptor.forClass(classOf[RotateImageFilter[RGBPixel]])
        .asInstanceOf[ArgumentCaptor[RotateImageFilter[RGBPixel]]]
    verify(cnf).addRGBFilter(captor.capture())
    assert(captor.getValue.degrees == 180)

  }
  test(".run test - dummy") {
    val cnf = new Config
    RotateFilterCmd(90, cnf).run()
    assert(cnf.getRGBFilters.head.isInstanceOf[RotateImageFilter[RGBPixel]])
    assert(cnf.getRGBFilters.head.asInstanceOf[RotateImageFilter[RGBPixel]].degrees == 90)
  }
  //todo regex test?
}
