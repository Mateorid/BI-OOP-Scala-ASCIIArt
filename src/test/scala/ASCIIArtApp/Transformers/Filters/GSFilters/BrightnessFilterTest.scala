package ASCIIArtApp.Transformers.Filters.GSFilters

import ASCIIArtApp.Models.{GSPixel, Image, PixelGrid}
import org.scalatest.FunSuite

class BrightnessFilterTest extends FunSuite {
  val gsImg3x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(1), GSPixel(2)),
      Seq[GSPixel](GSPixel(4), GSPixel(5), GSPixel(6)),
      Seq[GSPixel](GSPixel(100), GSPixel(155), GSPixel(255)),
    ))
  )
  val gsImg1x3 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0), GSPixel(120), GSPixel(255)),
    ))
  )
  val gsImg3x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(0)),
      Seq[GSPixel](GSPixel(120)),
      Seq[GSPixel](GSPixel(255))
    ))
  )
  val gsImg1x1 = new Image[GSPixel](
    new PixelGrid[GSPixel](Seq[Seq[GSPixel]](
      Seq[GSPixel](GSPixel(69)))))

  test("value too low") {
    assertThrows[IllegalArgumentException](new BrightnessFilter(-256))
    assertThrows[IllegalArgumentException](new BrightnessFilter(-420))
    assertThrows[IllegalArgumentException](new BrightnessFilter(-6969))
    assertThrows[IllegalArgumentException](new BrightnessFilter(Int.MinValue))
  }
  test("value too high") {
    assertThrows[IllegalArgumentException](new BrightnessFilter(256))
    assertThrows[IllegalArgumentException](new BrightnessFilter(420))
    assertThrows[IllegalArgumentException](new BrightnessFilter(6969))
    assertThrows[IllegalArgumentException](new BrightnessFilter(Int.MaxValue))
  }
  test("3x3 +brightness") {
    var value = 10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min(0.max(gsImg3x3.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min((gsImg3x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min((gsImg3x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("3x1 +brightness") {
    var value = 10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min(0.max(gsImg3x1.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min((gsImg3x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min((gsImg3x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("1x3 +brightness") {
    var value = 10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min(0.max(gsImg1x3.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min((gsImg1x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min((gsImg1x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("1x1 +brightness") {
    var value = 10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min(0.max(gsImg1x1.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min((gsImg1x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = 255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min((gsImg1x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("3x3 -brightness") {
    var value = -10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min(0.max(gsImg3x3.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min((gsImg3x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        val resVal = 255.min((gsImg3x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("3x1 -brightness") {
    var value = -10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min(0.max(gsImg3x1.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min((gsImg3x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        val resVal = 255.min((gsImg3x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("1x3 -brightness") {
    var value = -10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min(0.max(gsImg1x3.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min((gsImg1x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        val resVal = 255.min((gsImg1x3.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("1x1 -brightness") {
    var value = -10
    var fil = new BrightnessFilter(value)
    var res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min(0.max(gsImg1x1.getPixel(r, c).value + value))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -100
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min((gsImg1x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
    value = -255
    fil = new BrightnessFilter(value)
    res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        val resVal = 255.min((gsImg1x1.getPixel(r, c).value + value).max(0))
        assert(resVal == res.getPixel(r, c).value)
      }
    }
  }
  test("3x3 0 brightness") {
    val fil = new BrightnessFilter(0)
    val res = fil.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        assert(gsImg3x3.getPixel(r, c).value == res.getPixel(r, c).value)
      }
    }
  }
  test("3x1 0 brightness") {
    val fil = new BrightnessFilter(0)
    val res = fil.apply(gsImg3x1)
    for (r <- 0 until gsImg3x1.height) {
      for (c <- 0 until gsImg3x1.width) {
        assert(gsImg3x1.getPixel(r, c).value == res.getPixel(r, c).value)
      }
    }
  }
  test("1x3 0 brightness") {
    val fil = new BrightnessFilter(0)
    val res = fil.apply(gsImg1x3)
    for (r <- 0 until gsImg1x3.height) {
      for (c <- 0 until gsImg1x3.width) {
        assert(gsImg1x3.getPixel(r, c).value == res.getPixel(r, c).value)
      }
    }
  }
  test("1x1 0 brightness") {
    val fil = new BrightnessFilter(0)
    val res = fil.apply(gsImg1x1)
    for (r <- 0 until gsImg1x1.height) {
      for (c <- 0 until gsImg1x1.width) {
        assert(gsImg1x1.getPixel(r, c).value == res.getPixel(r, c).value)
      }
    }
  }
  test("+X == X"){
    val fil = new BrightnessFilter(10)
    val filP = new BrightnessFilter(+10)
    val res = fil.apply(gsImg3x3)
    val resP = filP.apply(gsImg3x3)
    for (r <- 0 until gsImg3x3.height) {
      for (c <- 0 until gsImg3x3.width) {
        assert(resP.getPixel(r, c).value == res.getPixel(r, c).value)
      }
    }
  }
}
