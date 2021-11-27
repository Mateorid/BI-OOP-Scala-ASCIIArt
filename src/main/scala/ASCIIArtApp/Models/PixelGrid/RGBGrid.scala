package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.RGBPixel

case class RGBGrid(pixelRows: Iterable[Iterable[RGBPixel]]) extends PixelGrid(Iterable(Iterable(RGBPixel))) {

}
