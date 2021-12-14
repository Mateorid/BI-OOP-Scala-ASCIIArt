package ASCIIArtApp.UI.Controller

import ASCIIArtApp.Exporters.TextExporter
import ASCIIArtApp.Loaders.RGBImageLoader
import ASCIIArtApp.Models.Pixel.Pixel
import ASCIIArtApp.ImageFilters.PixelGridFilter

trait ImageController[T <: Pixel, Y <: Pixel]
  extends Controller[RGBImageLoader, TextExporter, PixelGridFilter[T, Y]] {}
