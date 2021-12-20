package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{ASCIIPixel, GSPixel, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter

//Just a wrapper class for the app configuration info
class Config() {
  private var loader: RGBImageLoader = _
  private var exporters = Seq.empty[TextExporter]
  private var rgbFilters = Seq.empty[ImageFilter[RGBPixel]]
  private var gsFilters = Seq.empty[ImageFilter[GSPixel]]
  private var asciiFilters = Seq.empty[ImageFilter[ASCIIPixel]]

  def setLoader(in: RGBImageLoader): Unit = {
    if (loader != null)
      throw new IllegalArgumentException("--ERROR--\nThere can only be 1 input command!")
    loader = in
  }

  def addExporter(in: TextExporter): Unit = exporters = exporters :+ in

  def addRGBFilter(in: ImageFilter[RGBPixel]): Unit = rgbFilters = rgbFilters :+ in

  def addGSFilter(in: ImageFilter[GSPixel]): Unit = gsFilters = gsFilters :+ in

  def addASCIIFilter(in: ImageFilter[ASCIIPixel]): Unit = asciiFilters = asciiFilters :+ in

  def getLoader: RGBImageLoader = loader

  def getExporters: Seq[TextExporter] = exporters

  def getRGBFilters: Seq[ImageFilter[RGBPixel]] = rgbFilters

  def getGSFilters: Seq[ImageFilter[GSPixel]] = gsFilters

  def getASCIIFilters: Seq[ImageFilter[ASCIIPixel]] = asciiFilters
}
