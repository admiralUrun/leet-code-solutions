def equalPairs(grid: Array[Array[Int]]): Int = {
  val rowToCount = grid
    .map { ints => ints.toSeq }
    .groupBy(identity)
    .mapValues(_.length)

  grid.indices
    .map { i =>
      grid
        .indices
        .map { j => grid(j)(i) }
    }
    .groupBy(identity)
    .mapValues(_.length)
    .foldLeft(0) { case (acc, (key, count)) => acc + rowToCount.get(key).map(r => r * count).getOrElse(0) }
}