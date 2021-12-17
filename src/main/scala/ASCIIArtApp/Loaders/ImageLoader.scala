package ASCIIArtApp.Loaders

import ASCIIArtApp.Models.{Image, Pixel}

trait ImageLoader[T <: Pixel] extends Loader[Image[T]] {

}
