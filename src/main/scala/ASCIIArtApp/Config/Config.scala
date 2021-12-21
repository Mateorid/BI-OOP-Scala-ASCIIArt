package ASCIIArtApp.Config

import ASCIIArtApp.Exporters.Adapters.{ASCIIToStringAdapter, ExportAdapter}
import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.ImageLoaders.ImageLoader
import ASCIIArtApp.Loaders.ImageLoaders.RGBImageLoaders.RGBImageLoader
import ASCIIArtApp.Models.{ASCIIPixel, GSPixel, Image, RGBPixel}
import ASCIIArtApp.Transformers.Filters.ImageFilter
import ASCIIArtApp.Transformers.{GSToASCIITransformer, ImageTransformer, RGBToGSTransformer}

//Just a wrapper class for the app configuration info
class Config() {
  private var loader: ImageLoader[RGBPixel] = _
  private var exporters = Seq.empty[TextExporter]
  private var rgbFilters = Seq.empty[ImageFilter[RGBPixel]]
  private var gsFilters = Seq.empty[ImageFilter[GSPixel]]
  private var asciiFilters = Seq.empty[ImageFilter[ASCIIPixel]]
  private var rgbToGS: ImageTransformer[RGBPixel, GSPixel] = RGBToGSTransformer //default transformer
  private var gsToASCII: ImageTransformer[GSPixel, ASCIIPixel] = GSToASCIITransformer //default transformer
  private var printAdapter: ExportAdapter[Image[ASCIIPixel], String] = ASCIIToStringAdapter //default print adapter

  def setLoader(in: RGBImageLoader): Unit = {
    if (loader != null)
      throw new IllegalArgumentException("--ERROR--\nThere can only be 1 image loader!")
    loader = in
  }

  def addExporter(in: TextExporter): Unit = exporters = exporters :+ in

  def addRGBFilter(in: ImageFilter[RGBPixel]): Unit = rgbFilters = rgbFilters :+ in

  def addGSFilter(in: ImageFilter[GSPixel]): Unit = gsFilters = gsFilters :+ in

  def addASCIIFilter(in: ImageFilter[ASCIIPixel]): Unit = asciiFilters = asciiFilters :+ in

  def getLoader: ImageLoader[RGBPixel] = loader

  def getExporters: Seq[TextExporter] = exporters

  def getRGBFilters: Seq[ImageFilter[RGBPixel]] = rgbFilters

  def getGSFilters: Seq[ImageFilter[GSPixel]] = gsFilters

  def getASCIIFilters: Seq[ImageFilter[ASCIIPixel]] = asciiFilters

  def getRGBToGSTransformer: ImageTransformer[RGBPixel, GSPixel] = rgbToGS

  def getGSToASCIITransformer: ImageTransformer[GSPixel, ASCIIPixel] = gsToASCII

  def getAdapter: ExportAdapter[Image[ASCIIPixel], String] = printAdapter

  // These 3 should only be used for testing, unless other correctly working ones are provided
  def __setRGBToGSTransformer(in: ImageTransformer[RGBPixel, GSPixel]): Unit = rgbToGS = in

  def __setGSToASCIITransformer(in: ImageTransformer[GSPixel, ASCIIPixel]): Unit = gsToASCII = in

  def __setAdapter(in: ExportAdapter[Image[ASCIIPixel], String]): Unit = printAdapter = in
}
