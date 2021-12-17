package ASCIIArtApp.Models

import org.scalatest.FunSuite

class PixelGridTest extends FunSuite {

  val pixels3x3: List[List[Pixel]] = List[List[Pixel]](
    List[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
    List[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
    List[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
  )
  val pixels1x3: List[List[Pixel]] = List[List[Pixel]](
    List[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
  )

  val pixels3x1: List[List[Pixel]] = List[List[Pixel]](
    List[Pixel](CharPixel('A')),
    List[Pixel](GSPixel(1)),
    List[Pixel](CharPixel('A'))
  )
  val emptyPixels: List[List[Pixel]] = List.empty[List[Pixel]]
  val zeroPixels: List[List[Pixel]] = List[List[Pixel]]()
  val zeroPixels2: List[List[Pixel]] = List[List[Pixel]](List[Pixel]())

  object mockFilter {
    def run(x: Pixel): GSPixel = {
      GSPixel(0)
    }
  }


  test("Illegal pixels test") {
    assertThrows[IllegalArgumentException](new PixelGrid[Pixel](emptyPixels))
    assertThrows[IllegalArgumentException](new PixelGrid[Pixel](zeroPixels))
    assertThrows[IllegalArgumentException](new PixelGrid[Pixel](zeroPixels2))

  }
  test("3x3 grid getters") {
    val grid = new PixelGrid[Pixel](pixels3x3)
    assert(grid.height == 3)
    assert(grid.width == 3)
    assert(grid.getPixel(0, 0) == CharPixel('A'))
    assert(grid.getPixel(1, 1) == GSPixel(2))
    assert(grid.getPixel(2, 2) == CharPixel('C'))
    assertThrows[IllegalArgumentException](grid.getPixel(3, 3))
    assertThrows[IllegalArgumentException](grid.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, -1))
  }
  test("1x3 grid getters") {
    val grid = new PixelGrid[Pixel](pixels1x3)
    assert(grid.height == 1)
    assert(grid.width == 3)
    assert(grid.getPixel(0, 0) == CharPixel('A'))
    assert(grid.getPixel(0, 1) == CharPixel('B'))
    assert(grid.getPixel(0, 2) == CharPixel('C'))
    assertThrows[IllegalArgumentException](grid.getPixel(1, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, 3))
    assertThrows[IllegalArgumentException](grid.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, -1))
  }
  test("3x1 grid getters") {
    val grid = new PixelGrid[Pixel](pixels3x1)
    assert(grid.height == 3)
    assert(grid.width == 1)
    assert(grid.getPixel(0, 0) == CharPixel('A'))
    assert(grid.getPixel(1, 0) == GSPixel(1))
    assert(grid.getPixel(2, 0) == CharPixel('A'))
    assertThrows[IllegalArgumentException](grid.getPixel(0, 1))
    assertThrows[IllegalArgumentException](grid.getPixel(3, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, -1))
  }
  test("3x3 transform") {
    var grid = new PixelGrid[Pixel](pixels3x3)
    grid = grid.transform(mockFilter.run)
    assert(grid.getPixel(0, 0) == GSPixel(0))
    assert(grid.getPixel(0, 1) == GSPixel(0))
    assert(grid.getPixel(0, 2) == GSPixel(0))
    assert(grid.getPixel(1, 0) == GSPixel(0))
    assert(grid.getPixel(1, 1) == GSPixel(0))
    assert(grid.getPixel(1, 2) == GSPixel(0))
    assert(grid.getPixel(2, 0) == GSPixel(0))
    assert(grid.getPixel(2, 1) == GSPixel(0))
    assert(grid.getPixel(2, 2) == GSPixel(0))
  }
  test("1x3 transform") {
    var grid = new PixelGrid[Pixel](pixels1x3)
    grid = grid.transform(mockFilter.run)
    assert(grid.getPixel(0, 0) == GSPixel(0))
    assert(grid.getPixel(0, 1) == GSPixel(0))
    assert(grid.getPixel(0, 2) == GSPixel(0))
  }
  test("3x1 transform") {
    var grid = new PixelGrid[Pixel](pixels3x1)
    grid = grid.transform(mockFilter.run)
    assert(grid.getPixel(0, 0) == GSPixel(0))
    assert(grid.getPixel(1, 0) == GSPixel(0))
    assert(grid.getPixel(2, 0) == GSPixel(0))
  }


}
