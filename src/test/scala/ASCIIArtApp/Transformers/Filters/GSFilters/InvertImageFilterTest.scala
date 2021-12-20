package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.{GSPixel, Image, PixelGrid}
import org.scalatest.FunSuite

class InvertImageFilterTest extends FunSuite {
  val gsImg3x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(1), GSPixel(2)),
      Seq[GSPixel](GSPixel(4), GSPixel(5), GSPixel(6)),
      Seq[GSPixel](GSPixel(100), GSPixel(155), GSPixel(255)),
    ))
  )
  val correct3x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(255), GSPixel(254), GSPixel(253)),
      Seq[GSPixel](GSPixel(251), GSPixel(250), GSPixel(249)),
      Seq[GSPixel](GSPixel(155), GSPixel(100), GSPixel(0)),
    ))
  )
  val gsImg1x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(120), GSPixel(255)),
    ))
  )
  val correct1x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(255), GSPixel(135), GSPixel(0)),
    ))
  )
  val gsImg3x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0)),
      Seq[GSPixel](GSPixel(120)),
      Seq[GSPixel](GSPixel(255))
    ))
  )
  val correct3x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(255)),
      Seq[GSPixel](GSPixel(135)),
      Seq[GSPixel](GSPixel(0))
    ))
  )
  val gsImg1x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(69)))))
  val correct1x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(186)))))


  test("3x3") {
    val res = InvertImageFilter.apply(gsImg3x3)
    assert(res.equals(correct3x3))
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val value = gsImg3x3.getPixel(r, c).value
        assert(255 - value == res.getPixel(r, c).value)
      }
    }
  }
  test("1x3") {
    val res = InvertImageFilter.apply(gsImg1x3)
    assert(res.equals(correct1x3))
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val value = gsImg1x3.getPixel(r, c).value
        assert(255 - value == res.getPixel(r, c).value)
      }
    }
  }
  test("3x1") {
    val res = InvertImageFilter.apply(gsImg3x1)
    assert(res.equals(correct3x1))
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val value = gsImg3x1.getPixel(r, c).value
        assert(255 - value == res.getPixel(r, c).value)
      }
    }
  }
  test("1x1") {
    val res = InvertImageFilter.apply(gsImg1x1)
    assert(res.equals(correct1x1))
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val value = gsImg1x1.getPixel(r, c).value
        assert(255 - value == res.getPixel(r, c).value)
      }
    }
  }

}
