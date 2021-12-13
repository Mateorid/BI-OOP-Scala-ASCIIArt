package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, Pixel}
import ASCIIArtApp.Models.PixelGrid

trait PixelGridFilter[T <: Pixel, Y <: Pixel]
  extends Filter[PixelGrid[T], PixelGrid[Y]] {}
