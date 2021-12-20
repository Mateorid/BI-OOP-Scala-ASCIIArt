package ASCIIArtApp

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.Adapters.ASCIIToStringAdapter
import ASCIIArtApp.Transformers.{GSToASCIITransformer, RGBToGSTransformer}

object ImageTransformation {

  def run(config: Config): Unit = {
    if (config.getExporters.isEmpty)
      throw new IllegalArgumentException("Missing exporter!")
    if (config.getLoader == null)
      throw new IllegalArgumentException("Missing loader!")

    //Load RGB image
    var rgbImg = config.getLoader.load()

    //RGB filters
    for (i <- config.getRGBFilters)
      rgbImg = i.apply(rgbImg)

    //RGB -> GS conversion
    var gsImg = RGBToGSTransformer.apply(rgbImg)

    //GS filters
    for (i <- config.getGSFilters)
      gsImg = i.apply(gsImg)

    //GS -> ASCII conversion
    var asciiImg = GSToASCIITransformer.apply(gsImg)

    //ASCII filters
    for (i <- config.getASCIIFilters)
      asciiImg = i.apply(asciiImg)

    //Export
    val printableImg = ASCIIToStringAdapter.adapt(asciiImg)
    for (i <- config.getExporters)
      i.`export`(printableImg)
  }
}
