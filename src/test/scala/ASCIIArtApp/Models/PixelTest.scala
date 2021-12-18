package ASCIIArtApp.Models

import org.scalatest.FunSuite

import java.awt.Color

class PixelTest extends FunSuite {

  test("RGBPixel test") {
    val color = new Color(123, 123, 123)
    val rgbPixel = RGBPixel(color)
    assert(rgbPixel.value == color)
  }
  test("RGBPixel null color") {
    assertThrows[IllegalArgumentException](RGBPixel(null))
  }
  test("CharPixel test") {
    val charPixel = CharPixel('&')
    assert(charPixel.value == '&')
  }
  test("GSPixel test") {
    val gsPixel = GSPixel(69)
    assert(gsPixel.value == 69)
  }
  test("Out of range GSPixel") {
    assertThrows[IllegalArgumentException](GSPixel(256))
    assertThrows[IllegalArgumentException](GSPixel(420))
    assertThrows[IllegalArgumentException](GSPixel(Int.MaxValue))
    assertThrows[IllegalArgumentException](GSPixel(-1))
    assertThrows[IllegalArgumentException](GSPixel(-255))
    assertThrows[IllegalArgumentException](GSPixel(Int.MinValue))
  }
}
