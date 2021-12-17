package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter

class Config() {
  var loader: RGBImageLoader = _
  var exporters = List.empty[TextExporter]
  var rgbFilters = List.empty[ImageFilter[RGBPixel]]
  var gsFilters = List.empty[ImageFilter[GSPixel]]
  var asciiFilters = List.empty[ImageFilter[CharPixel]]
}
