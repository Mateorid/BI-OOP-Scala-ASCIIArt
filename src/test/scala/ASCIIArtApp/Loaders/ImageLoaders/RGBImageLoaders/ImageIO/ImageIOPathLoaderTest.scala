package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO

import ASCIIArtApp.Models.{Image, RGBPixel}
import org.scalatest.FunSuite

import java.awt.Color

class ImageIOPathLoaderTest extends FunSuite {
  test("File doesnt exist"){
    assertThrows[IllegalArgumentException](new ImageIOPathLoader("src/test/scala/testFiles/sdkghjak.jpg").load())
  }
  test("Filetype not supported"){
    assertThrows[IllegalArgumentException](new ImageIOPathLoader("src/test/scala/testFiles/tmp.txt").load())

  }
  test("1x1") {
    val res = new ImageIOPathLoader("src/test/scala/testFiles/test1x1.png").load()
    assert(res.isInstanceOf[Image[RGBPixel]])
    assert(res.height == 1)
    assert(res.width == 1)
    assert(res.getPixel(0, 0).value == Color.BLACK)
  }
  test("2x2") {
    val res = new ImageIOPathLoader("src/test/scala/testFiles/test2x2.png").load()
    assert(res.isInstanceOf[Image[RGBPixel]])
    assert(res.height == 2)
    assert(res.width == 2)
    assert(res.getPixel(0, 0).value == Color.RED)
    assert(res.getPixel(0, 1).value == Color.GREEN)
    assert(res.getPixel(1, 0).value == Color.BLUE)
    assert(res.getPixel(1, 1).value == Color.WHITE)
  }
  test("20x20") {
    val res = new ImageIOPathLoader("src/test/scala/testFiles/test20x20.png").load()
    assert(res.isInstanceOf[Image[RGBPixel]])
    assert(res.height == 20)
    assert(res.width == 20)
    for (h <- 0 until 10; w <- 0 until 10)
      assert(res.getPixel(h, w).value == Color.RED)
    for (h <- 0 until 10; w <- 10 until 20)
      assert(res.getPixel(h, w).value == Color.GREEN)
    for (h <- 10 until 20; w <- 0 until 10)
      assert(res.getPixel(h, w).value == Color.BLUE)
    for (h <- 10 until 20; w <- 10 until 20)
      assert(res.getPixel(h, w).value == Color.WHITE)
  }
  test("20x10 + jpg") {
    val res = new ImageIOPathLoader("src/test/scala/testFiles/test20x10.jpg").load()
    assert(res.isInstanceOf[Image[RGBPixel]])
    assert(res.height == 20)
    assert(res.width == 10)
    for (h <- 0 until 10; w <- 0 until 5)
      assert(res.getPixel(h, w).value == Color.RED)
    for (h <- 0 until 10; w <- 10 until 10)
      assert(res.getPixel(h, w).value == Color.GREEN)
    for (h <- 10 until 20; w <- 0 until 5)
      assert(res.getPixel(h, w).value == Color.BLUE)
    for (h <- 10 until 20; w <- 10 until 10)
      assert(res.getPixel(h, w).value == Color.WHITE)
  }

}
