package ASCIIArtApp.UI.Controller

import ASCIIArtApp.Facades.ImageFacade
import ASCIIArtApp.Models.Pixel.GSPixel


class GSFiltersImageController(img: ImageFacade)
  extends ImageController[GSPixel, GSPixel] {

  //  override def setOutput(out: String): Unit =
  //    if (out == null)
  //      exporter = new StdOutputExporter
  //    else
  //      exporter = new FileOutputExporter(new File(out))
  //
  //  override def addFilter(filter: Filter[PixelGrid[GSPixel], PixelGrid[GSPixel]]): Unit = {
  //    filters = filters :+ filter
  //  }

  override def executeCommands(): Unit = {
    img.setRGB(loader.load())
    img.applyFilters(filters)
  }

  override def export(): Unit = exporter.export(img.toString)

}
