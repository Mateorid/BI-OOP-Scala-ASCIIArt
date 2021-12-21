package ASCIIArtApp.Loaders.ImageLoaders

import ASCIIArtApp.Loaders.Loader
import ASCIIArtApp.Models.{Image, Pixel}

trait ImageLoader[T <: Pixel] extends Loader[Image[T]] {}
