package ASCIIArtApp.Transformers

import ASCIIArtApp.Models._
import org.scalatest.FunSuite

class GSToASCIITransformerTest extends FunSuite {
  private val charRamp =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  val gsImg3x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(1), GSPixel(2)),
      Seq[GSPixel](GSPixel(4), GSPixel(5), GSPixel(6)),
      Seq[GSPixel](GSPixel(8), GSPixel(100), GSPixel(255)),
    ))
  )
  val correct3x3 = new Image[ASCIIPixel](
    new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
      Seq[ASCIIPixel](ASCIIPixel('$'), ASCIIPixel('$'), ASCIIPixel('$')),
      Seq[ASCIIPixel](ASCIIPixel('@'), ASCIIPixel('@'), ASCIIPixel('@')),
      Seq[ASCIIPixel](ASCIIPixel('B'), ASCIIPixel('U'), ASCIIPixel(' ')),
    )))
  val gsImg1x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(120), GSPixel(255)),
    ))
  )
  val correct1x3 = new Image[ASCIIPixel](
    new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
      Seq[ASCIIPixel](ASCIIPixel('$'), ASCIIPixel('v'), ASCIIPixel(' ')),
    ))
  )
  val gsImg3x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0)),
      Seq[GSPixel](GSPixel(120)),
      Seq[GSPixel](GSPixel(255))
    ))
  )
  val correct3x1 = new Image[ASCIIPixel](
    new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
      Seq[ASCIIPixel](ASCIIPixel('$')),
      Seq[ASCIIPixel](ASCIIPixel('v')),
      Seq[ASCIIPixel](ASCIIPixel(' '))
    ))
  )
  val gsImg1x1 = new Image[GSPixel](new PixelGrid[GSPixel](
    Seq[Seq[GSPixel]](Seq[GSPixel](GSPixel('X')))
  ))
  val correct1x1 = new Image[ASCIIPixel](
    new PixelGrid[ASCIIPixel](Seq[Seq[ASCIIPixel]](
      Seq[ASCIIPixel](ASCIIPixel('Q')))))


  test("3x3") {
    val res = GSToASCIITransformer.apply(gsImg3x3)
    assert(res.equals(correct3x3))
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val value = gsImg3x3.getPixel(r, c).value
        assert(res.getPixel(r, c).value == charRamp.charAt((charRamp.length - 1) * value / 255))
      }
    }
  }
  test("1x3") {
    val res = GSToASCIITransformer.apply(gsImg1x3)
    assert(res.equals(correct1x3))
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val value = gsImg1x3.getPixel(r, c).value
        assert(res.getPixel(r, c).value == charRamp.charAt((charRamp.length - 1) * value / 255))
      }
    }
  }
  test("3x1") {
    val res = GSToASCIITransformer.apply(gsImg3x1)
    assert(res.equals(correct3x1))
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val value = gsImg3x1.getPixel(r, c).value
        assert(res.getPixel(r, c).value == charRamp.charAt((charRamp.length - 1) * value / 255))
      }
    }

  }
  test("1x1") {
    val res = GSToASCIITransformer.apply(gsImg1x1)
    assert(res.equals(correct1x1))
    val value = gsImg1x1.getPixel(0,0).value
    assert(res.getPixel(0,0).value == charRamp.charAt((charRamp.length - 1) * value / 255))}
}
