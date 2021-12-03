package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.CharPixel

case class CharGrid(pixelRows: List[List[CharPixel]])
    extends PixelGrid(List(List(CharPixel))) {}
