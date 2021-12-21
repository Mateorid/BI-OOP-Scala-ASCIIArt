package ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO

import org.scalatest.FunSuite

class ImageIOURLLoaderTest extends FunSuite {

  test("invalid URL") {
    val loader = ImageIOURLLoader("fufusite.nope")
    assertThrows[IllegalArgumentException](loader.load())
  }
  test("empty URL") {
    val loader = ImageIOURLLoader("")
    assertThrows[IllegalArgumentException](loader.load())
  }
  test("null URL") {
    val loader = ImageIOURLLoader(null)
    assertThrows[IllegalArgumentException](loader.load())
  }
  //I'm not sure if testing based on outside source like this is ok or not
  //And its not even a mandatory part of the project so I'll just leave it here commented :)

  //  test("correct URL"){
  //    val loader = ImageIOURLLoader("https://www.google.com/logos/doodles/2021/winter-2021-northern-hemisphere-6753651837109164-s.png")
  //    assert(loader.load().isInstanceOf[Image[RGBPixel]])
  //  }
}
