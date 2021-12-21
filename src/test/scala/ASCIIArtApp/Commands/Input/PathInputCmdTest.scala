package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO.ImageIOPathLoader
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
      ArgumentCaptor.forClass(classOf[ImageIOPathLoader])
        .asInstanceOf[ArgumentCaptor[ImageIOPathLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.path == path)
  }
  //todo regex test?
}
