package ASCIIArtApp.Models

import org.scalatest.FunSuite

class ImageTest extends FunSuite {
  val grid3x3: PixelGrid[Pixel] = new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
    Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
    Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
  ))
  val grid1x3: PixelGrid[Pixel] = new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
  ))

  val grid3x1: PixelGrid[Pixel] = new PixelGrid[Pixel](Seq[Seq[Pixel]](
    Seq[Pixel](ASCIIPixel('A')),
    Seq[Pixel](GSPixel(1)),
    Seq[Pixel](ASCIIPixel('A'))
  ))
  val grid1x1 = new PixelGrid[Pixel](
    Seq[Seq[Pixel]](Seq[Pixel](ASCIIPixel('X')))
  )

  object mockFilter {
    def run(x: Pixel): GSPixel = {
      GSPixel(69)
    }
  }

  test("Illegal pixel grid") {
    assertThrows[IllegalArgumentException](new Image(new PixelGrid[Pixel](Seq.empty[Seq[Pixel]])))
    assertThrows[IllegalArgumentException](new Image(new PixelGrid[Pixel](Seq[Seq[Pixel]]())))
    assertThrows[IllegalArgumentException](new Image(new PixelGrid[Pixel](Seq[Seq[Pixel]](Seq[Pixel]()))))
  }

  test("3x3 getters") {
    val img = new Image[Pixel](grid3x3)
    assert(img.width == 3)
    assert(img.height == 3)
    assert(img.getPixel(0, 0) == ASCIIPixel('A'))
    assert(img.getPixel(0, 1) == ASCIIPixel('B'))
    assert(img.getPixel(0, 2) == ASCIIPixel('C'))
    assert(img.getPixel(1, 0) == GSPixel(1))
    assert(img.getPixel(1, 1) == GSPixel(2))
    assert(img.getPixel(1, 2) == GSPixel(3))
    assert(img.getPixel(2, 0) == ASCIIPixel('A'))
    assert(img.getPixel(2, 1) == ASCIIPixel('B'))
    assert(img.getPixel(2, 2) == ASCIIPixel('C'))
    assertThrows[IllegalArgumentException](img.getPixel(3, 3))
    assertThrows[IllegalArgumentException](img.getPixel(3, 0))
    assertThrows[IllegalArgumentException](img.getPixel(0, 3))
    assertThrows[IllegalArgumentException](img.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](img.getPixel(0, -1))
    assertThrows[IllegalArgumentException](img.getPixel(-1, -1))
  }
  test("1x3 getters") {
    val img = new Image[Pixel](grid1x3)
    assert(img.height == 1)
    assert(img.width == 3)
    assert(img.getPixel(0, 0) == ASCIIPixel('A'))
    assert(img.getPixel(0, 1) == ASCIIPixel('B'))
    assert(img.getPixel(0, 2) == ASCIIPixel('C'))
    assertThrows[IllegalArgumentException](img.getPixel(1, 0))
    assertThrows[IllegalArgumentException](img.getPixel(0, 3))
    assertThrows[IllegalArgumentException](img.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](img.getPixel(0, -1))
    assertThrows[IllegalArgumentException](img.getPixel(-1, -1))
  }
  test("3x1 grid getters") {
    val img = new Image[Pixel](grid3x1)
    assert(img.height == 3)
    assert(img.width == 1)
    assert(img.getPixel(0, 0) == ASCIIPixel('A'))
    assert(img.getPixel(1, 0) == GSPixel(1))
    assert(img.getPixel(2, 0) == ASCIIPixel('A'))
    assertThrows[IllegalArgumentException](img.getPixel(0, 1))
    assertThrows[IllegalArgumentException](img.getPixel(3, 0))
    assertThrows[IllegalArgumentException](img.getPixel(-1, 0))
    assertThrows[IllegalArgumentException](img.getPixel(-1, -1))
    assertThrows[IllegalArgumentException](img.getPixel(0, -1))
  }
  test("1x1 getters"){
    val grid = new Image[Pixel](grid1x1)
    assert(grid.height == 1)
    assert(grid.width == 1)
    assert(grid.getPixel(0, 0) == ASCIIPixel('X'))
  }
  test("3x3 transform") {
    var img = new Image[Pixel](grid3x3)
    img = img.transform(mockFilter.run)
    assert(img.getPixel(0, 0) == GSPixel(69))
    assert(img.getPixel(0, 1) == GSPixel(69))
    assert(img.getPixel(0, 2) == GSPixel(69))
    assert(img.getPixel(1, 0) == GSPixel(69))
    assert(img.getPixel(1, 1) == GSPixel(69))
    assert(img.getPixel(1, 2) == GSPixel(69))
    assert(img.getPixel(2, 0) == GSPixel(69))
    assert(img.getPixel(2, 1) == GSPixel(69))
    assert(img.getPixel(2, 2) == GSPixel(69))
  }
  test("1x3 transform") {
    var img = new Image[Pixel](grid1x3)
    img = img.transform(mockFilter.run)
    assert(img.getPixel(0, 0) == GSPixel(69))
    assert(img.getPixel(0, 1) == GSPixel(69))
    assert(img.getPixel(0, 2) == GSPixel(69))
  }
  test("3x1 transform") {
    var img = new Image[Pixel](grid3x1)
    img = img.transform(mockFilter.run)
    assert(img.getPixel(0, 0) == GSPixel(69))
    assert(img.getPixel(1, 0) == GSPixel(69))
    assert(img.getPixel(2, 0) == GSPixel(69))
  }
  test("1x1 transform") {
    var grid = new Image[Pixel](grid1x1)
    grid = grid.transform(mockFilter.run)
    assert(grid.getPixel(0, 0) == GSPixel(69))
  }
  test("equaling equals 3x3") {
    val img3x3 = new Image[Pixel](grid3x3)
    val alt3x3 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
      Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
    )))
    val fail3x3 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
      Seq[Pixel](GSPixel(1), GSPixel(2), GSPixel(3)),
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('A')),
    )))
    assert(img3x3.equals(img3x3))
    assert(img3x3.equals(alt3x3))
    assert(!img3x3.equals(fail3x3))
  }
  test("equaling equals 3x1") {
    val img3x1 = new Image[Pixel](grid3x1)
    val alt3x1 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A')),
      Seq[Pixel](GSPixel(1)),
      Seq[Pixel](ASCIIPixel('A'))
    )))
    assert(img3x1.equals(img3x1))
    assert(img3x1.equals(alt3x1))
  }
  test("equaling equals 1x3") {
    val img1x3 = new Image[Pixel](grid1x3)
    val alt1x3 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('B'), ASCIIPixel('C')),
    )))
    assert(img1x3.equals(img1x3))
    assert(img1x3.equals(alt1x3))
  }
  test("equaling equals 1x1") {
    val img1x1 = new Image[Pixel](grid1x1)
    val alt1x1 = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](Seq[Pixel](ASCIIPixel('X')))))
    assert(img1x1.equals(img1x1))
    assert(img1x1.equals(alt1x1))
  }
  test("equals with not equal by height") {
    val img3x3 = new Image[Pixel](grid3x3)
    val img1x3 = new Image[Pixel](grid1x3)
    assert(!img3x3.equals(img1x3))
    assert(!img1x3.equals(img3x3))
  }
  test("equals with not equal by width") {
    val img3x3 = new Image[Pixel](grid3x3)
    val img3x1 = new Image[Pixel](grid3x1)
    assert(!img3x3.equals(img3x1))
    assert(!img3x1.equals(img3x3))
  }
  test("equals with not equal by Pixel") {
    val img1x3 = new Image[Pixel](grid1x3)
    val differentType = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A'), GSPixel(69), ASCIIPixel('C')),
    )))
    val differentValue = new Image[Pixel](new PixelGrid[Pixel](Seq[Seq[Pixel]](
      Seq[Pixel](ASCIIPixel('A'), ASCIIPixel('C'), ASCIIPixel('C')),
    )))
    assert(!img1x3.equals(differentType))
    assert(!img1x3.equals(differentValue))
    assert(!differentValue.equals(img1x3))
    assert(!differentType.equals(img1x3))
  }
}
