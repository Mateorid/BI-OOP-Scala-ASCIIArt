package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.RandomRGBImageLoader
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class RandomInputCmdTest extends FunSuite {
  test(".run test") {
    val cnf = mock[Config]
    RandomInputCmd(30, 30, cnf).run()
    val captor =
      ArgumentCaptor.forClass(classOf[RandomRGBImageLoader])
        .asInstanceOf[ArgumentCaptor[RandomRGBImageLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.width == 30)
    assert(captor.getValue.height == 30)
  }
}
