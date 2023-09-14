def uniquePaths(m: Int, n: Int): Int = {
  val cache = Array.fill(m)(Array.fill(n)(-1))

  def dp(row: Int, col: Int): Int = {
    if (row + col == 0) 1
    else if (cache(row)(col) != -1) cache(row)(col)
    else {
      var count = 0
      if (row > 0) count += dp(row - 1, col)
      if (col > 0) count += dp(row, col - 1)

      cache(row)(col) = count
      count
    }
  }

  dp(m - 1, n - 1)
}