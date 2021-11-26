package ASCIIArtApp.Models

import ASCIIArtApp.Models.Pixel.RGBPixel

import scala.collection.mutable.ArrayBuffer

class PixelRow() {
  protected var pixelList = new ArrayBuffer[RGBPixel]
//
//  def addPixel(pixel: RGBPixel): Unit = {
//    pixelList :+= pixel
//  }
//
//  def getPixels(): ArrayBuffer[RGBPixel] = {
//    pixelList
//  }
}
