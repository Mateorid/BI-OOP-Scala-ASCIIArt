package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models._
import org.scalatest.FunSuite

import java.awt.Color

class RotateImageFilterTest extends FunSuite {
  val mixed3x3 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
    Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
    Seq[Pixel](RGBPixel(new Color(69)), RGBPixel(new Color(420)), RGBPixel(new Color(666))),
  )))
  val correct3x3R = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](RGBPixel(new Color(69)), GSPixel(1), CharPixel('A')),
    Seq[Pixel](RGBPixel(new Color(420)), GSPixel(2), CharPixel('B')),
    Seq[Pixel](RGBPixel(new Color(666)), GSPixel(3), CharPixel('C')),
  )))
  val correct3x3L = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('C'), GSPixel(3), RGBPixel(new Color(666))),
    Seq[Pixel](CharPixel('B'), GSPixel(2), RGBPixel(new Color(420))),
    Seq[Pixel](CharPixel('A'), GSPixel(1), RGBPixel(new Color(69))),
  )))
  val correct3x3UD = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](RGBPixel(new Color(666)), RGBPixel(new Color(420)), RGBPixel(new Color(69))),
    Seq[Pixel](GSPixel(3), GSPixel(2), GSPixel(1)),
    Seq[Pixel](CharPixel('C'), CharPixel('B'), CharPixel('A')),
  )))
  val mixed1x3 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C'))))
  )
  val correct1x3R = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A')),
    Seq[Pixel](CharPixel('B')),
    Seq[Pixel](CharPixel('C'))))
  )
  val correct1x3L = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('C')),
    Seq[Pixel](CharPixel('B')),
    Seq[Pixel](CharPixel('A'))))
  )
  val correct1x3UD = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('C'), CharPixel('B'), CharPixel('A'))))
  )
  val mixed3x1 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A')),
    Seq[Pixel](GSPixel(1)),
    Seq[Pixel](RGBPixel(new Color(69)))))
  )
  val correct3x1L = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A'), GSPixel(1), RGBPixel(new Color(69)))))
  )
  val correct3x1R = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](RGBPixel(new Color(69)), GSPixel(1), CharPixel('A'))))
  )
  val correct3x1UD = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](RGBPixel(new Color(69))),
    Seq[Pixel](GSPixel(1)),
    Seq[Pixel](CharPixel('A'))))
  )
  val mixed1x1 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](Seq[Pixel](CharPixel('X')))))


  test("mixed pixels 3x3 90") {
    val filter = new RotateImageFilter[Pixel](+90)
    val res = filter.apply(mixed3x3)
    assert(res.equals(correct3x3R))
  }
  test("mixed pixels 3x3 -90") {
    val filter = new RotateImageFilter[Pixel](-90)
    val res = filter.apply(mixed3x3)
    assert(res.equals(correct3x3L))
  }
  test("mixed pixels 3x3 180") {
    val filter = new RotateImageFilter[Pixel](180)
    val res = filter.apply(mixed3x3)
    assert(res.equals(correct3x3UD))
  }
  test("mixed pixels 1x3 90") {
    val filter = new RotateImageFilter[Pixel](90)
    val res = filter.apply(mixed1x3)
    assert(res.equals(correct1x3R))
  }
  test("mixed pixels 1x3 -90") {
    val filter = new RotateImageFilter[Pixel](-90)
    val res = filter.apply(mixed1x3)
    assert(res.equals(correct1x3L))
  }
  test("mixed pixels 1x3 180") {
    val filter = new RotateImageFilter[Pixel](180)
    val res = filter.apply(mixed1x3)
    assert(res.equals(correct1x3UD))
  }
  test("mixed pixels 3x1 90") {
    val filter = new RotateImageFilter[Pixel](90)
    val res = filter.apply(mixed3x1)
    assert(res.equals(correct3x1R))
  }
  test("mixed pixels 3x1 -90") {
    val filter = new RotateImageFilter[Pixel](-90)
    val res = filter.apply(mixed3x1)
    assert(res.equals(correct3x1L))
  }
  test("mixed pixels 3x1 180") {
    val filter = new RotateImageFilter[Pixel](180)
    val res = filter.apply(mixed3x1)
    assert(res.equals(correct3x1UD))
  }
  test("mixed pixels 1x1 90") {
    val filter = new RotateImageFilter[Pixel](90)
    val res = filter.apply(mixed1x1)
    assert(res.equals(mixed1x1))
  }
  test("mixed pixels 1x1 -90") {
    val filter = new RotateImageFilter[Pixel](-90)
    val res = filter.apply(mixed1x1)
    assert(res.equals(mixed1x1))
  }
  test("mixed pixels 1x1 180") {
    val filter = new RotateImageFilter[Pixel](180)
    val res = filter.apply(mixed1x1)
    assert(res.equals(mixed1x1))
  }
  test("+90 == 90 == -270") {
    val filter = new RotateImageFilter[Pixel](90)
    val res = filter.apply(mixed3x3)

    val filterPlus = new RotateImageFilter[Pixel](+90)
    val resPlus = filterPlus.apply(mixed3x3)


    val filterMinus = new RotateImageFilter[Pixel](-270)
    val resMinus = filterMinus.apply(mixed3x3)

    assert(res.equals(correct3x3R))
    assert(resPlus.equals(correct3x3R))
    assert(resMinus.equals(correct3x3R))
  }
  test("-90 == 270") {
    val filter = new RotateImageFilter[Pixel](-90)
    val res = filter.apply(mixed3x3)

    val filterMinus = new RotateImageFilter[Pixel](270)
    val resMinus = filterMinus.apply(mixed3x3)

    assert(res.equals(correct3x3L))
    assert(resMinus.equals(correct3x3L))
  }
  test("+180 == 180 == -180") {
    val filter = new RotateImageFilter[Pixel](180)
    val res = filter.apply(mixed3x3)

    val filterPlus = new RotateImageFilter[Pixel](+180)
    val resPlus = filterPlus.apply(mixed3x3)

    val filterMinus = new RotateImageFilter[Pixel](-180)
    val resMinus = filterMinus.apply(mixed3x3)

    assert(res.equals(correct3x3UD))
    assert(resPlus.equals(correct3x3UD))
    assert(resMinus.equals(correct3x3UD))
    assert(resPlus.equals(res))
    assert(resMinus.equals(res))
  }
  test("Over 360 degrees rotations right") {
    val r = new RotateImageFilter[Pixel](90)
    val res = r.apply(mixed3x3)

    val r1 = new RotateImageFilter[Pixel](450)
    val res1 = r1.apply(mixed3x3)

    val r2 = new RotateImageFilter[Pixel](810)
    val res2 = r2.apply(mixed3x3)

    val r3 = new RotateImageFilter[Pixel](1170)
    val res3 = r3.apply(mixed3x3)

    assert(res.equals(correct3x3R))
    assert(res1.equals(correct3x3R))
    assert(res2.equals(correct3x3R))
    assert(res3.equals(correct3x3R))
  }
  test("Over 360 degrees rotations left") {
    val r = new RotateImageFilter[Pixel](-90)
    val res = r.apply(mixed3x3)

    val r1 = new RotateImageFilter[Pixel](-450)
    val res1 = r1.apply(mixed3x3)

    val r2 = new RotateImageFilter[Pixel](-810)
    val res2 = r2.apply(mixed3x3)

    val r3 = new RotateImageFilter[Pixel](-1170)
    val res3 = r3.apply(mixed3x3)

    assert(res.equals(correct3x3L))
    assert(res1.equals(correct3x3L))
    assert(res2.equals(correct3x3L))
    assert(res3.equals(correct3x3L))
  }
  test("Over 360 degrees rotations upside down") {
    val r = new RotateImageFilter[Pixel](180)
    val res = r.apply(mixed3x3)

    val r1 = new RotateImageFilter[Pixel](540)
    val res1 = r1.apply(mixed3x3)

    val r2 = new RotateImageFilter[Pixel](900)
    val res2 = r2.apply(mixed3x3)

    val r3 = new RotateImageFilter[Pixel](1260)
    val res3 = r3.apply(mixed3x3)

    assert(res.equals(correct3x3UD))
    assert(res1.equals(correct3x3UD))
    assert(res2.equals(correct3x3UD))
    assert(res3.equals(correct3x3UD))
  }
  test("Not x*90 degree input") {
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](1))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](-1))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](89))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](91))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](-89))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](-91))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](179))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](361))
    assertThrows[IllegalArgumentException](new RotateImageFilter[Pixel](-361))
  }
}
