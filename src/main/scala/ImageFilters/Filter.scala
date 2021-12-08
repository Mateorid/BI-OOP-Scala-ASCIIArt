package ImageFilters

trait Filter[T] {
  /**
   * Applies a filter on provided item
   *
   * @param item input
   * @return item with applied filter
   */
  def apply(item: T): T
}
