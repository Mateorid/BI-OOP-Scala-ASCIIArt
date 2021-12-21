package ASCIIArtApp.UI

import ASCIIArtApp.AppExecutionLogic.ConfigExecutor
import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.{FileOutputExporter, StdOutputExporter}
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.ImageIO.{ImageIOPathLoader, ImageIOURLLoader}
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.RandomRGBImageLoader
import ASCIIArtApp.Models.RGBPixel
import ASCIIArtApp.Transformers.Filters.GSFilters.{BrightnessFilter, InvertImageFilter}
import ASCIIArtApp.Transformers.Filters.RotateImageFilter
import org.mockito.ArgumentCaptor
import org.mockito.MockitoSugar.{times, verify}
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

class ConsoleInputHandlerTest extends FunSuite {

  test("No args") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    assertThrows[IllegalArgumentException](cih.handleInput(Seq.empty[String]))
  }
  test("--image arg") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--image", "fake/location/booba.png")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[ImageIOPathLoader])
        .asInstanceOf[ArgumentCaptor[ImageIOPathLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.path == "fake/location/booba.png")
  }
  test("--image-url arg") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--image-url", "https://booba.tv")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[ImageIOURLLoader])
        .asInstanceOf[ArgumentCaptor[ImageIOURLLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.url == "https://booba.tv")
  }
  test("--image-random") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--image-random", "69", "420")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[RandomRGBImageLoader])
        .asInstanceOf[ArgumentCaptor[RandomRGBImageLoader]]
    verify(cnf).setLoader(captor.capture())
    assert(captor.getValue.height == 69)
    assert(captor.getValue.width == 420)
  }
  test("--invert") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--invert")
    cih.handleInput(args)
    verify(exec).run(cnf)
    verify(cnf).addGSFilter(InvertImageFilter)
  }
  test("--rotate X") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--rotate", "-180")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[RotateImageFilter[RGBPixel]])
        .asInstanceOf[ArgumentCaptor[RotateImageFilter[RGBPixel]]]
    verify(cnf).addRGBFilter(captor.capture())
    assert(captor.getValue.degrees == -180)
  }
  test("--brightness X") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--brightness", "69")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[BrightnessFilter])
        .asInstanceOf[ArgumentCaptor[BrightnessFilter]]
    verify(cnf).addGSFilter(captor.capture())
    assert(captor.getValue.value == 69)
  }
  test("--output-console") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--output-console")
    cih.handleInput(args)
    verify(exec).run(cnf)
    verify(cnf).addExporter(StdOutputExporter)
  }
  test("--output-file X") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--output-file", "src\\test\\scala\\testFiles\\tmp.txt")
    cih.handleInput(args)
    verify(exec).run(cnf)
    val captor =
      ArgumentCaptor.forClass(classOf[FileOutputExporter])
        .asInstanceOf[ArgumentCaptor[FileOutputExporter]]
    verify(cnf).addExporter(captor.capture())
    assert(captor.getValue.file.getPath == args(1))
  }
  test("All arguments") {
    val cnf = mock[Config]
    val exec = mock[ConfigExecutor]
    val cih = new ConsoleInputHandler(cnf, exec)
    val args = Seq[String]("--image-random", "69", "420", "--invert", "--rotate", "90", "--brightness", "-10",
      "--output-console", "--output-file", "src\\test\\scala\\testFiles\\tmp.txt")
    cih.handleInput(args)
    verify(exec).run(cnf)
    //--image-random
    val ir =
      ArgumentCaptor.forClass(classOf[RandomRGBImageLoader])
        .asInstanceOf[ArgumentCaptor[RandomRGBImageLoader]]
    verify(cnf).setLoader(ir.capture())
    assert(ir.getValue.height == 69)
    assert(ir.getValue.width == 420)
    //--invert
    verify(cnf).addGSFilter(InvertImageFilter)
    //--rotate
    val rt =
      ArgumentCaptor.forClass(classOf[RotateImageFilter[RGBPixel]])
        .asInstanceOf[ArgumentCaptor[RotateImageFilter[RGBPixel]]]
    verify(cnf).addRGBFilter(rt.capture())
    assert(rt.getValue.degrees == 90)
    //brightness
    val br =
      ArgumentCaptor.forClass(classOf[BrightnessFilter])
        .asInstanceOf[ArgumentCaptor[BrightnessFilter]]
    verify(cnf, times(2)).addGSFilter(br.capture())
    assert(br.getValue.value == -10)
    //output-console
    verify(cnf).addExporter(StdOutputExporter)
    //output-file
    val of =
      ArgumentCaptor.forClass(classOf[FileOutputExporter])
        .asInstanceOf[ArgumentCaptor[FileOutputExporter]]
    verify(cnf, times(2)).addExporter(of.capture())
    assert(of.getValue.file.getPath == args(10))
  }
}
