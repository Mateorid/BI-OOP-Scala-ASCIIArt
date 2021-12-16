package ASCIIArtApp.UI

import ASCIIArtApp.Config.Config
import ASCIIArtApp.Exporters.{FileOutputExporter, StdOutputExporter}
import ASCIIArtApp.ImageTransformation
import ASCIIArtApp.Loaders.RGBImageLoaders.{PathRGBImageLoader, RandomRGBImageLoader, URLRGBImageLoader}
import ASCIIArtApp.Models.RGBPixel
import ASCIIArtApp.Transformers.Filters.GSFilters.{BrightnessFilter, InvertImageFilter}
import ASCIIArtApp.Transformers.Filters.RotateImageFilter

import java.io.File
import scala.collection.mutable.ArrayBuffer

object ConsoleInputHandler extends InputHandler[Array[String]] {
  val config = new Config

  def handleInput(commands: Array[String]): Unit = {
    val parsed = parseCommands(commands)

    for (i <- parsed)
      processCommand(i)

    ImageTransformation.run(config)
    //    controller.runCommands()
    //    controller.export()
  }

  //todo fix this parser for multi argument commands
  private def parseCommands(commands: Array[String]): Array[String] = {
    val parsed = new ArrayBuffer[String]
    var cmd = new String
    var lastWasArg = false

    for (i <- commands)
      if (i.startsWith("--")) {
        if (lastWasArg) {
          parsed += cmd
          cmd = ""
        }
        cmd = i
        lastWasArg = true
      } else {
        cmd += " " + i
        parsed += cmd
        cmd = ""
        lastWasArg = false
      }
    if (cmd != "")
      parsed += cmd

    parsed.toArray
  }

  //  private def processCommand(command: String): Unit = {
  //    //todo match RegEx Patterns or can it be done like this?
  //    val tmp: Regex = "--image-random (\\d+ \\d+)$".r
  //    val tmp2: Regex = "--image (\\S*)$".r
  //
  //    command match {
  //      case tmp(x, y) => println("--image-random " + x.getClass + " " + y);
  //      case tmp2(x) => println("--image-path -> " + x );
  //      case PathInputCommand.
  //      case _         => throw new Exception("UR GAE")
  //    }
  //
  ////    val cmd = new RegExCommand(command.r)
  ////    cmd match {
  ////      case URLInputCommand(_)    => URLInputCommand(controller).run(command)
  ////      case RandomInputCommand(_) => RandomInputCommand(controller).run(command)
  ////      case ConsoleOutputCommand(_) =>
  ////        ConsoleOutputCommand(controller).run(command)
  ////      case FileOutputCommand(_) => FileOutputCommand(controller).run(command)
  ////      case BrightnessFilterCommand(_) =>
  ////        BrightnessFilterCommand(controller).run(command)
  ////      case InvertFilterCommand(_) =>
  ////        InvertFilterCommand(controller).run(command)
  ////      case RotateFilterCommand(_) =>
  ////        RotateFilterCommand(controller).run(command)
  ////      case _ =>
  ////        throw new IllegalArgumentException("Unknown command!") //todo print available commands?
  ////    }
  //    //todo delete
  //    throw new Exception("success")
  //  }

  //todo change this to the labs version - regex matcher etc
  private def processCommand(command: String): Unit = {
    //Input file
    if (command.startsWith("--image-url")) {
      config.loader = new URLRGBImageLoader(command.substring(8))
      //      controller.setInput(new URLRGBImageLoader(command.substring(8)))
      return
    } else if (command.startsWith("--image-random")) { //todo RandomGenerator taking 2 argument height X width
      config.loader = new RandomRGBImageLoader(40, 40)
      //      controller.setInput(new RandomRGBImageLoader(40, 40))
      return
    } else if (command.startsWith("--image")) {
      //todo check for filetype we cant handle .png for example
      config.loader = new PathRGBImageLoader(command.substring(8))
      //      controller.setInput(new PathRGBImageLoader(command.substring(8)))
      return
    }
    //Output file
    if (command.startsWith("--output-file")) {
      val file = new File(command.substring(14))
      config.exporter = new FileOutputExporter(file)
      //      controller.setOutput(new FileOutputExporter(file))
      return
    } else if (command == "--output-console") {
      config.exporter = StdOutputExporter
      //      controller.setOutput(StdOutputExporter)
      return
    }

    //Filters
    if (command.startsWith("--rotate")) {
      //todo try catch this
      val degrees: Int = command.substring(9).toInt
      if (degrees % 90 != 0)
        throw new Exception(
          "Incorrect command format, --rotation supports only 90 degrees rotations")
      val filter = new RotateImageFilter[RGBPixel](degrees)
      config.rgbFilters = config.rgbFilters :+ filter
      //      controller.addFilter(new RotateImageFilter(degrees))
      return
    } else if (command.startsWith("--brightness")) {
      //todo try catch this
      val x: Int = command.substring(13).toInt
      val filter = new BrightnessFilter(x)
      config.gsFilters = config.gsFilters :+ filter
      //      controller.addFilter(new BrightnessFilter(x))
      return
    }
    command match {
      case "--invert" =>
        config.gsFilters = config.gsFilters :+ InvertImageFilter
      //        controller.addFilter(InvertImageFilter)
      case _ => throw new Exception("Incorrect command, use \"help\" for help")
    }
  }

}
