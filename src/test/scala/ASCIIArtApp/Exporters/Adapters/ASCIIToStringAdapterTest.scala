package ASCIIArtApp.Exporters.Adapters

import ASCIIArtApp.Models.{ASCIIPixel, Image, PixelGrid}
import org.scalatest.FunSuite

class ASCIIToStringAdapterTest extends FunSuite {
  val img3x3 = new Image(new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
    Seq[ASCIIPixel](ASCIIPixel('M'), ASCIIPixel('O'), ASCIIPixel('D')),
    Seq[ASCIIPixel](ASCIIPixel('A'), ASCIIPixel('R'), ASCIIPixel('E')),
    Seq[ASCIIPixel](ASCIIPixel('G'), ASCIIPixel('A'), ASCIIPixel('Y')),
  )))
  val img1x3 = new Image(new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
    Seq[ASCIIPixel](ASCIIPixel('B'), ASCIIPixel('O'), ASCIIPixel('B')),
  )))

  val img3x1 = new Image(new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
    Seq[ASCIIPixel](ASCIIPixel('4')),
    Seq[ASCIIPixel](ASCIIPixel('2')),
    Seq[ASCIIPixel](ASCIIPixel('0'))
  )))
  val img1x1 = new Image(new PixelGrid[ASCIIPixel](
    Seq[Seq[ASCIIPixel]](Seq[ASCIIPixel](ASCIIPixel('X')))
  ))

  test("3x3") {
    val res = ASCIIToStringAdapter.adapt(img3x3)
    val expected ="MOD\nARE\nGAY\n"
    assert(res == expected)
  }
  test("1x3") {
    val res = ASCIIToStringAdapter.adapt(img1x3)
    val expected ="BOB\n"
    assert(res == expected)
  }
  test("3x1") {
    val res = ASCIIToStringAdapter.adapt(img3x1)
    val expected ="4\n2\n0\n"
    assert(res == expected)
  }
  test("1x1") {
    val res = ASCIIToStringAdapter.adapt(img1x1)
    val expected ="X\n"
    assert(res == expected)
  }

}
