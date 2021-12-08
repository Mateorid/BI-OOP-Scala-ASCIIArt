package ImageFilters

import ASCIIArtApp.Models.Pixel.{GSPixel, Pixel}
import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait ImageFilter[T<:Pixel[_]] extends Filter[PixelGrid[T]] {}
