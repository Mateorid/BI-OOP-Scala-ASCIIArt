package ASCIIArtApp.Models

import org.scalatest.FunSuite

import java.awt.Color

class PixelTest extends FunSuite {

  test("testRGBPixel") {
    val color = new Color(123, 123, 123)
    val rgbPixel = RGBPixel(color)
    assert(rgbPixel.value == color)
  }

  test("null color") {
    val rgbPixel = RGBPixel(null)
    assert(rgbPixel.value == null)
  }

  test("testCharPixel") {
    val charPixel = CharPixel('&')
    assert(charPixel.value == '&')
  }

  test("testGSPixel") {
    val gsPixel = GSPixel(420)
    assert(gsPixel.value == 420)
  }
}
