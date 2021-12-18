package ASCIIArtApp.Models

import org.scalatest.FunSuite

class PixelGridTest extends FunSuite {
  //ok pixels
  val pixels3x3: Seq[Seq[Pixel]] = Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
    Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
    Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
  )
  val pixels1x3: Seq[Seq[Pixel]] = Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
  )

  val pixels3x1: Seq[Seq[Pixel]] = Seq[Seq[Pixel]](
    Seq[Pixel](CharPixel('A')),
    Seq[Pixel](GSPixel(1)),
    Seq[Pixel](CharPixel('A'))
  )
  val pixels1x1: Seq[Seq[Pixel]] = Seq[Seq[Pixel]](Seq[Pixel](CharPixel('X')))
  //faulty ones
  val emptyPixels: Seq[Seq[Pixel]] = Seq.empty[Seq[Pixel]]
  val zeroPixels: Seq[Seq[Pixel]] = Seq[Seq[Pixel]]()
  val zeroPixels2: Seq[Seq[Pixel]] = Seq[Seq[Pixel]](Seq[Pixel]())

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
    assert(grid.getPixel(0, 1) == CharPixel('B'))
    assert(grid.getPixel(0, 2) == CharPixel('C'))
    assert(grid.getPixel(1, 0) == GSPixel(1))
    assert(grid.getPixel(1, 1) == GSPixel(2))
    assert(grid.getPixel(1, 2) == GSPixel(3))
    assert(grid.getPixel(2, 0) == CharPixel('A'))
    assert(grid.getPixel(2, 1) == CharPixel('B'))
    assert(grid.getPixel(2, 2) == CharPixel('C'))
    assertThrows[IllegalArgumentException](grid.getPixel(3, 3))
    assertThrows[IllegalArgumentException](grid.getPixel(3, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, 3))
    assertThrows[IllegalArgumentException](grid.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](grid.getPixel(0, -1))
    assertThrows[IllegalArgumentException](grid.getPixel(-1, -1))
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
  test("1x1 grid getters") {
    val grid = new PixelGrid[Pixel](pixels1x1)
    assert(grid.height == 1)
    assert(grid.width == 1)
    assert(grid.getPixel(0, 0) == CharPixel('X'))
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
  test("1x1 transform") {
    var grid = new PixelGrid[Pixel](pixels1x1)
    grid = grid.transform(mockFilter.run)
    assert(grid.getPixel(0, 0) == GSPixel(0))
  }
  test("equaling equals 3x3") {
    val grid3x3 = new PixelGrid[Pixel](pixels3x3)
    val alt3x3 = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
      Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
      Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
    ))
    val fail3x3 = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
      Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
      Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('A')),
    ))
    assert(grid3x3.equals(grid3x3))
    assert(grid3x3.equals(alt3x3))
    assert(!grid3x3.equals(fail3x3))
  }
  test("equaling equals 3x1") {
    val grid3x1 = new PixelGrid[Pixel](pixels3x1)
    val alt3x1 = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A')),
      Seq[Pixel](GSPixel(1)),
      Seq[Pixel](CharPixel('A'))
    ))
    assert(grid3x1.equals(grid3x1))
    assert(grid3x1.equals(alt3x1))
  }
  test("equaling equals 1x3") {
    val grid1x3 = new PixelGrid[Pixel](pixels1x3)
    val alt1x3 = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A'), CharPixel('B'), CharPixel('C')),
    ))
    assert(grid1x3.equals(grid1x3))
    assert(grid1x3.equals(alt1x3))
  }
  test("equaling equals 1x1") {
    val grid1x1 = new PixelGrid[Pixel](pixels1x1)
    val alt1x1 = new PixelGrid[Pixel](Seq[Seq[Pixel]](Seq[Pixel](CharPixel('X'))))
    assert(grid1x1.equals(grid1x1))
    assert(grid1x1.equals(alt1x1))
  }
  test("equals with not equal by height") {
    val grid3x3 = new PixelGrid[Pixel](pixels3x3)
    val grid1x3 = new PixelGrid[Pixel](pixels1x3)
    assert(!grid3x3.equals(grid1x3))
    assert(!grid1x3.equals(grid3x3))
  }
  test("equals with not equal by width") {
    val grid3x3 = new PixelGrid[Pixel](pixels3x3)
    val grid3x1 = new PixelGrid[Pixel](pixels3x1)
    assert(!grid3x3.equals(grid3x1))
    assert(!grid3x1.equals(grid3x3))
  }
  test("equals with not equal by Pixel") {
    val grid1x3 = new PixelGrid[Pixel](pixels1x3)
    val differentType = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A'), GSPixel(69), CharPixel('C')),
    ))
    val differentValue = new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](CharPixel('A'), CharPixel('C'), CharPixel('C')),
    ))
    assert(!grid1x3.equals(differentType))
    assert(!grid1x3.equals(differentValue))
    assert(!differentValue.equals(grid1x3))
    assert(!differentType.equals(grid1x3))
  }
}
