package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.RGBPixel

case class RGBGrid(pixelRows: List[List[RGBPixel]])
    extends PixelGrid[RGBPixel](pixelRows) {}
