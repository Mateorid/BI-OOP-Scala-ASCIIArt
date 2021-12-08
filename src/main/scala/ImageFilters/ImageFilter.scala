package ImageFilters

import ASCIIArtApp.Models.Pixel.GSPixel
import ASCIIArtApp.Models.PixelGrid

trait ImageFilter extends Filter[PixelGrid[GSPixel]] {}
