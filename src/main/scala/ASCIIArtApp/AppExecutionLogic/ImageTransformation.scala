package ASCIIArtApp.AppExecutionLogic

import ASCIIArtApp.Config.Config

//Transformation logic
object ImageTransformation extends ConfigExecutor {

  override def run(config: Config): Unit = {
    if (config.getLoader == null)
      throw new IllegalArgumentException("Missing loader!")
    if (config.getExporters.isEmpty)
    throw new IllegalArgumentException("Missing exporter!")

    //Load RGB image
    var rgbImg = config.getLoader.load()

    //RGB filters
    for (i <- config.getRGBFilters)
      rgbImg = i.apply(rgbImg)

    //RGB -> GS conversion
    var gsImg = config.getRGBToGSTransformer.apply(rgbImg)

    //GS filters
    for (i <- config.getGSFilters)
      gsImg = i.apply(gsImg)

    //GS -> ASCII conversion
    var asciiImg = config.getGSToASCIITransformer.apply(gsImg)

    //ASCII filters
    for (i <- config.getASCIIFilters)
      asciiImg = i.apply(asciiImg)

    //Export
    val printableImg = config.getAdapter.adapt(asciiImg)
    for (i <- config.getExporters)
      i.`export`(printableImg)
  }
}
