package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders

import ASCIIArtApp.Models.RGBPixel
import org.scalatest.FunSuite

class RandomRGBImageLoaderTest extends FunSuite {

  test("1x1"){
    val loader = RandomRGBImageLoader(1, 1)
    val res = loader.load()
    assert(res.height == 1)
    assert(res.width == 1)
    assert(res.getPixel(0,0).isInstanceOf[RGBPixel])
  }

  test("5x1"){
    val loader = RandomRGBImageLoader(5, 1)
    val res = loader.load()
    assert(res.height == 5)
    assert(res.width == 1)
    for (h <- 0 until 5; w <- 0 until 1)
      assert(res.getPixel(h,w).isInstanceOf[RGBPixel])
  }
  test("1x5"){
    val loader = RandomRGBImageLoader(1, 5)
    val res = loader.load()
    assert(res.height == 1)
    assert(res.width == 5)
    for (h <- 0 until 1; w <- 0 until 5)
      assert(res.getPixel(h,w).isInstanceOf[RGBPixel])
  }
  test("5x5"){
    val loader = RandomRGBImageLoader(5, 5)
    val res = loader.load()
    assert(res.height == 5)
    assert(res.width == 5)
    for (h <- 0 until 5; w <- 0 until 5)
      assert(res.getPixel(h,w).isInstanceOf[RGBPixel])
  }
}
