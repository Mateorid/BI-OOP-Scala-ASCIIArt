package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.GSPixel

case class GSGrid(pixelRows: Iterable[Iterable[GSPixel]]) extends PixelGrid(Iterable(Iterable(GSPixel))) {

}
