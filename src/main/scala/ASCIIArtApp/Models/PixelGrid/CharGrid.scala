package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.CharPixel

case class CharGrid(pixelRows: Iterable[Iterable[CharPixel]]) extends PixelGrid(Iterable(Iterable(CharPixel))) {

}