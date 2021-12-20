package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.{Image, Pixel}

trait ImageLoader[T <: Pixel] extends Loader[Image[T]] {
  protected val supportedTypes: Seq[String] = Seq[String](".jpg", ".png", ".gif") //todo create a pathImgLoader trait and put it there
}
