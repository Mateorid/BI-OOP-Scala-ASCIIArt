package ImageFilters

trait ImageFilter[T] {
  val priority: Int

  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  def apply(item: T): T
}
