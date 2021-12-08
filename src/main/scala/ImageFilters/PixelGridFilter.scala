package ImageFilters

import ASCIIArtApp.Models.Pixel.Pixel
import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait PixelGridFilter[T <: PixelGrid[_]] extends ImageFilter[T] {}
