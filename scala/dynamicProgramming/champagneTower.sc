def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
  val cache = scala.collection.mutable.HashMap((0, 0) -> poured.toDouble)

  def excess(double: Double): Double = if (double < 1) 0 else (double - 1d) / 2d

  def champagneTower(row: Int, col: Int): Double = {
    if (cache contains(row, col)) cache((row, col))
    else if (col >= 0 && col <= row) {
      val left = champagneTower(row - 1, col - 1)
      val right = champagneTower(row - 1, col)

      cache((row, col)) = excess(left) + excess(right)
      cache((row, col))
    } else 0d
  }

  val ans = champagneTower(query_row, query_glass)

  if (ans >= 1) 1
  else ans
}