package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter

class Config() { //todo to setters and getters
  var loader: RGBImageLoader = _
  var exporter: TextExporter = _
  var rgbFilters = List.empty[ImageFilter[RGBPixel]]
  //  var rgbFilters = List.empty[ImageTransformer[RGBPixel, RGBPixel]]
  var gsFilters = List.empty[ImageFilter[GSPixel]]
  //  var gsFilters = List.empty[ImageTransformer[GSPixel, GSPixel]]
  var asciiFilters = List.empty[ImageFilter[CharPixel]]
  //  var asciiFilters = List.empty[ImageTransformer[CharPixel, CharPixel]]
}
