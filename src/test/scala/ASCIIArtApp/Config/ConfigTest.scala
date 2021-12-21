package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{ASCIIPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter
import org.scalatest.FunSuite
import org.scalatestplus.mockito.MockitoSugar.mock


class ConfigTest extends FunSuite {
  test("testSetLoader") {
    val cfg = new Config
    val loader = mock[RGBImageLoader]
    cfg.setLoader(loader)
    assert(cfg.getLoader == loader)
  }

  test("Set already set loader") {
    val cfg = new Config
    val loader = mock[RGBImageLoader]
    val loader2 = mock[RGBImageLoader]
    cfg.setLoader(loader)
    assertThrows[IllegalArgumentException](cfg.setLoader(loader2))
  }

  test("testAddExporter") {
    val cfg = new Config
    val exporter = mock[TextExporter]
    cfg.addExporter(exporter)
    assert(cfg.getExporters.contains(exporter))
  }

  test("testAddASCIIFilter") {
    val cfg = new Config
    val filter = mock[ImageFilter[ASCIIPixel]]
    cfg.addASCIIFilter(filter)
    assert(cfg.getASCIIFilters.contains(filter))
  }

  test("testAddRGBFilter") {
    val cfg = new Config
    val filter = mock[ImageFilter[RGBPixel]]
    cfg.addRGBFilter(filter)
    assert(cfg.getRGBFilters.contains(filter))
  }

  test("testAddGSFilter") {
    val cfg = new Config
    val filter = mock[ImageFilter[GSPixel]]
    cfg.addGSFilter(filter)
    assert(cfg.getGSFilters.contains(filter))
  }
}
