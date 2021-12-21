package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models.Pixel
import ASCIIArtApp.Transformers.PixelTransformer

trait PixelFilter[T <: Pixel] extends PixelTransformer[T, T] with ImageFilter[T] {}
