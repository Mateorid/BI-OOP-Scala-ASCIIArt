package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO.ImageIOURLLoader
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class URLInputCmdTest extends FunSuite {
  test(".run test"){
    val cnf = mock[Config]
    val url = "your.mom/booba.png"
    URLInputCmd(url,cnf).run()
    val captor =
      ArgumentCaptor.forClass(classOf[ImageIOURLLoader])
        .asInstanceOf[ArgumentCaptor[ImageIOURLLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.url == url)
  }
}
