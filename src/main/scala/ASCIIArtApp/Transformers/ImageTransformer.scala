package ASCIIArtApp.Transformers

import ASCIIArtApp.Models.{Image, Pixel}

trait ImageTransformer[T <: Pixel, Y <: Pixel]
    extends Transformer[Image[T], Image[Y]] {}
