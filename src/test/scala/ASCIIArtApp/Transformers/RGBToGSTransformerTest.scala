package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{Image, PixelGrid, RGBPixel}
import org.scalatest.FunSuite

import java.awt.Color

class RGBToGSTransformerTest extends FunSuite {
  val rgb3x3 = new Image[RGBPixel](
    new PixelGrid[RGBPixel](Seq[Seq[RGBPixel]](
      Seq[RGBPixel](RGBPixel(new Color(420)), RGBPixel(new Color(420420)), RGBPixel(new Color(420420420))),
      Seq[RGBPixel](RGBPixel(new Color(42069)), RGBPixel(new Color(69420)), RGBPixel(new Color(6942069))),
      Seq[RGBPixel](RGBPixel(new Color(696969)), RGBPixel(new Color(69)), RGBPixel(new Color(69))),
    ))
  )

  val rgb1x3 = new Image[RGBPixel](
    new PixelGrid[RGBPixel](Seq[Seq[RGBPixel]](
      Seq[RGBPixel](RGBPixel(new Color(7)), RGBPixel(new Color(777)), RGBPixel(new Color(7777777))),
    ))
  )

  val rgb3x1 = new Image[RGBPixel](
    new PixelGrid[RGBPixel](Seq[Seq[RGBPixel]](
      Seq[RGBPixel](RGBPixel(new Color(42))),
      Seq[RGBPixel](RGBPixel(new Color(4242))),
      Seq[RGBPixel](RGBPixel(new Color(424242)))
    ))
  )

  val rgb1x1 = new Image[RGBPixel](
    new PixelGrid[RGBPixel](Seq[Seq[RGBPixel]](
      Seq[RGBPixel](RGBPixel(new Color(66642069)))))
  )

  test("3x3") {
    val res = RGBToGSTransformer.apply(rgb3x3)
    for (r <- 0 until rgb3x3.height) {
      for (c <- 0 until rgb3x3.width) {
        val color = rgb3x3.getPixel(r, c).value
        val correctGS = (0.3 * color.getRed) + (0.59 * color.getGreen) + (0.11 * color.getBlue)
        assert(res.getPixel(r, c).value == correctGS.toInt)
      }
    }
  }
  test("1x3") {
    val res = RGBToGSTransformer.apply(rgb1x3)
    for (c <- 0 until rgb3x3.width) {
      val color = rgb1x3.getPixel(0, c).value
      val correctGS = (0.3 * color.getRed) + (0.59 * color.getGreen) + (0.11 * color.getBlue)
      assert(res.getPixel(0, c).value == correctGS.toInt)
    }
  }
  test("3x1") {
    val res = RGBToGSTransformer.apply(rgb3x1)
    for (r <- 0 until rgb3x3.height) {
      val color = rgb3x1.getPixel(r, 0).value
      val correctGS = (0.3 * color.getRed) + (0.59 * color.getGreen) + (0.11 * color.getBlue)
      assert(res.getPixel(r, 0).value == correctGS.toInt)
    }
  }
  test("1x1") {
    val res = RGBToGSTransformer.apply(rgb1x1)
    val color = rgb1x1.getPixel(0, 0).value
    val correctGS = (0.3 * color.getRed) + (0.59 * color.getGreen) + (0.11 * color.getBlue)
    assert(res.getPixel(0, 0).value == correctGS.toInt)
  }
}
