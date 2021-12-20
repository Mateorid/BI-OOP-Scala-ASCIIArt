package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter

//Just a wrapper class for the app configuration info
class Config() {
  var loader: RGBImageLoader = _
  var exporters = Seq.empty[TextExporter]
  var rgbFilters = Seq.empty[ImageFilter[RGBPixel]]
  var gsFilters = Seq.empty[ImageFilter[GSPixel]]
  var asciiFilters = Seq.empty[ImageFilter[CharPixel]]
}
