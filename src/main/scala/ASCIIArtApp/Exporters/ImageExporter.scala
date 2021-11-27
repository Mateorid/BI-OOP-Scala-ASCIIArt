package ASCIIArtApp.Exporters

import ASCIIArtApp.Models.PixelGrid.PixelGrid

trait ImageExporter[T] extends Exporter[PixelGrid[T]] {

}
