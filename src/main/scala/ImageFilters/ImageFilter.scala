package ImageFilters

import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait ImageFilter[T <: PixelGrid[_]] extends Filter[T] {}
