package ASCIIArtApp

import ASCIIArtApp.UI.ConsoleInputHandler
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class MainTest extends FunSuite {
  test("Main test") {
    val cih = mock[ConsoleInputHandler]
    cih.handleInput(List[String]("ooga", "booga"))
    val captor = ArgumentCaptor.forClass(classOf[List[String]])
      .asInstanceOf[ArgumentCaptor[List[String]]]
    verify(cih).handleInput(captor.capture())
    val args = captor.getValue
    assert(args.head == "ooga")
    assert(args(1) == "booga")
  }
}
