package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.ImageTransformer

class Config() { //todo like this or setters and getters?
  var loader: RGBImageLoader = _
  var exporter: TextExporter = _
  var rgbFilters = List.empty[ImageTransformer[RGBPixel, RGBPixel]]
  var gsFilters = List.empty[ImageTransformer[GSPixel, GSPixel]]
  var asciiFilters = List.empty[ImageTransformer[CharPixel, CharPixel]]
}
