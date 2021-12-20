package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.RGBImageLoaders.PathRGBImageLoader
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class PathInputCmdTest extends FunSuite {
  test(".run test"){
    val cnf = mock[Config]
    val path = "you/mom/booba.txt"
    PathInputCmd(path,cnf).run()
    val captor =
      ArgumentCaptor.forClass(classOf[PathRGBImageLoader])
        .asInstanceOf[ArgumentCaptor[PathRGBImageLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.path == path)
  }
  //todo regex test?
}
