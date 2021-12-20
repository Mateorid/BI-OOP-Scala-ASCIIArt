package ASCIIArtApp.Commands.Input

import ASCIIArtApp.Config.Config
import org.scalatest.FunSuite

class PathInputCmdTest extends FunSuite {
  test(".run test"){
    val cnf = new Config //its just a wrapper class no need to mock it right?
    val path = "src\\main\\scala\\TestImages\\xd.txt"
    PathInputCmd(path,cnf).run()

  }
  //todo regex test?
}
