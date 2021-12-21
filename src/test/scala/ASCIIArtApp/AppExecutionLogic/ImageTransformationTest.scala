package ASCIIArtApp.AppExecutionLogic

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.Adapters.ExportAdapter
import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{ASCIIPixel, GSPixel, Image, RGBPixel}
import ASCIIArtApp.Transformers.Filters.GSFilters.BrightnessFilter
import ASCIIArtApp.Transformers.Filters.{ImageFilter, RotateImageFilter}
import ASCIIArtApp.Transformers.ImageTransformer
import org.mockito.MockitoSugar.verify
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.language.postfixOps

class ImageTransformationTest extends FunSuite {

  test("No loader") {
    assertThrows[IllegalArgumentException](ImageTransformation.run(new Config))
  }
  test("No exporter") {
    val cnf = new Config
    cnf.setLoader(mock[RGBImageLoader])
    assertThrows[IllegalArgumentException](ImageTransformation.run(cnf))
  }
  test("Ok run - no filters") {
    val cfg = new Config
    val loader = mock[RGBImageLoader]
    val exporter = mock[TextExporter]
    val adapter = mock[ExportAdapter[Image[ASCIIPixel], String]]
    val rtg = mock[ImageTransformer[RGBPixel, GSPixel]]
    val gta = mock[ImageTransformer[GSPixel, ASCIIPixel]]

    cfg.setLoader(loader)
    cfg.addExporter(exporter)
    cfg.__setRGBToGSTransformer(rtg)
    cfg.__setGSToASCIITransformer(gta)
    cfg.__setAdapter(adapter)

    assert(ImageTransformation.run(cfg) == ())
    verify(loader).load()
    verify(exporter).`export`(null)
    verify(adapter).adapt(null)
    verify(rtg).apply(null)
    verify(gta).apply(null)
  }
  test("Ok run - with filters") {
    val cfg = new Config
    val loader = mock[RGBImageLoader]
    val exporter = mock[TextExporter]
    val adapter = mock[ExportAdapter[Image[ASCIIPixel], String]]
    val rtg = mock[ImageTransformer[RGBPixel, GSPixel]]
    val gta = mock[ImageTransformer[GSPixel, ASCIIPixel]]
    val f1 = mock[RotateImageFilter[RGBPixel]]
    val f2 = mock[BrightnessFilter]
    val f3 = mock[ImageFilter[ASCIIPixel]]

    cfg.setLoader(loader)
    cfg.addExporter(exporter)
    cfg.addRGBFilter(f1)
    cfg.addGSFilter(f2)
    cfg.addASCIIFilter(f3)
    cfg.__setRGBToGSTransformer(rtg)
    cfg.__setGSToASCIITransformer(gta)
    cfg.__setAdapter(adapter)

    assert(ImageTransformation.run(cfg) == ())
    verify(loader).load()
    verify(exporter).`export`(null)
    verify(adapter).adapt(null)
    verify(rtg).apply(null)
    verify(gta).apply(null)
    verify(f1).apply(null)
    verify(f2).apply(null)
    verify(f3).apply(null)
  }
}
