package ASCIIArtApp.AppExecutionLogic

import ASCIIArtApp.Config.Config

trait ConfigExecutor {
  def run(config: Config): Unit
}
