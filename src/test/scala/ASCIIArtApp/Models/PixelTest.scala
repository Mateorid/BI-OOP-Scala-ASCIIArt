package ASCIIArtApp.Models

import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel, RGBPixel}
import org.scalatest.FunSuite

class PixelTest extends FunSuite {

  private val rgbPixel = RGBPixel(123, 456, 789)
  private val charPixel = CharPixel('&')
  private val gsPixel = GSPixel(420)

  test("testRGBPixel") {
    assert(rgbPixel.get == (123,456,789))
  }

  test("testCharPixel") {
    assert(charPixel.get == '&')
  }

  test("testGSPixel") {
    assert(gsPixel.get == 420)
  }

}
