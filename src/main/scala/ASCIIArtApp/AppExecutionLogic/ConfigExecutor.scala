package ASCIIArtApp.AppExecutionLogic

import ASCIIArtApp.Config.Config

trait ConfigExecutor {
  /**
   * Executes the provided config
   */
  def run(config: Config): Unit
}
