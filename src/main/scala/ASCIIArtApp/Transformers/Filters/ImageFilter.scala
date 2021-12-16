package ASCIIArtApp.Transformers.Filters

import ASCIIArtApp.Models.Pixel
import ASCIIArtApp.Transformers.ImageTransformer

trait ImageFilter[T <: Pixel] extends ImageTransformer[T, T] {}
