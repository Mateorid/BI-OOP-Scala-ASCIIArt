package ASCIIArtApp.Facades

import ASCIIArtApp.Models.Image.Image
import ASCIIArtApp.Models.Pixel.{CharPixel, GSPixel, RGBPixel}
import ASCIIArtApp.ImageFilters.{GSToASCIIFilter, PixelGridFilter, RGBToGSFilter}

class ImageFacade {

  private var rgbImg: Option[Image[RGBPixel]] = None
  private var gsImg: Option[Image[GSPixel]] = None
  private var asciiImg: Option[Image[CharPixel]] = None

  def setRGB(image: Image[RGBPixel]): Unit = rgbImg = Option.apply(image)

  def setGS(image: Image[GSPixel]): Unit = gsImg = Option.apply(image)

  def setASCII(image: Image[CharPixel]): Unit = asciiImg = Option.apply(image)

  def getRGB: Option[Image[RGBPixel]] = rgbImg

  def getGS: Option[Image[GSPixel]] = gsImg

  def getASCII: Option[Image[CharPixel]] = asciiImg


  def applyFilters(filters: List[PixelGridFilter[GSPixel, GSPixel]]): Unit = {
    if (gsImg.isEmpty) {
      gsImg = Option.apply(toGrayScale)
    }
    for (i <- filters)
      gsImg = Option.apply(gsImg.get.applyGridFilter(i.applyFilter))
  }

  private def transformToASCII: Image[CharPixel] = {
    gsImg.get.applyGridFilter(GSToASCIIFilter.applyFilter)
  }

  private def toGrayScale: Image[GSPixel] = {
    rgbImg.get.applyGridFilter(RGBToGSFilter.applyFilter)
  }

  override def toString: String = {
    if (asciiImg.isEmpty)
      asciiImg = Option.apply(transformToASCII)
    asciiImg.get.toString
  }
}
