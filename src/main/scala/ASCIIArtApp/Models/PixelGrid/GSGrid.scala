package ASCIIArtApp.Models.PixelGrid

import ASCIIArtApp.Models.Pixel.GSPixel

case class GSGrid(pixelRows: List[List[GSPixel]]) extends PixelGrid(List(List(GSPixel))) {

}
