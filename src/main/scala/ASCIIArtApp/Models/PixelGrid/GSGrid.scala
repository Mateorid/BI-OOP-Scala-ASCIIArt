package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.GSPixel

class GSGrid(pixelRows: List[List[GSPixel]])
    extends PixelGrid[GSPixel](pixelRows) {}
