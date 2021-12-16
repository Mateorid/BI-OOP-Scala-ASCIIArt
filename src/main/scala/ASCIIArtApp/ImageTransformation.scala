package ASCIIArtApp

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.Adapters.ASCIIToStringAdapter
import ASCIIArtApp.Transformers.{GSToASCIITransformer, RGBToGSTransformer}

object ImageTransformation {

  def run(config: Config): Unit = {
    if (config.exporter == null || config.loader == null)
      throw new IllegalArgumentException("Missing exporter or loader!")

    //Load RGB image
    var rgbImg = config.loader.load()

    //RGB filters
    for (i <- config.rgbFilters)
      rgbImg = i.apply(rgbImg)

    //RGB -> GS conversion
    var gsImg = RGBToGSTransformer.apply(rgbImg)

    //GS filters
    for (i <- config.gsFilters)
      gsImg = i.apply(gsImg)

    //GS -> ASCII conversion
    var asciiImg = GSToASCIITransformer.apply(gsImg)

    //ASCII filters
    for (i <- config.asciiFilters)
      asciiImg = i.apply(asciiImg)

    //Export
    val printableImg = ASCIIToStringAdapter.adapt(asciiImg)
    config.exporter.`export`(printableImg)
  }
}
