def minimumEffortPath(heights: Array[Array[Int]]): Int = {
  val directions = Array((0, 1), (1, 0), (0, -1), (-1, 0))
  val n = heights.length
  val m = heights.head.length

  def dfs(maxEffort: Int): Boolean = {
    val seen = scala.collection.mutable.HashSet((0, 0))
    val stack = scala.collection.mutable.Queue((0, 0))

    while (stack.nonEmpty) {
      val (row, col) = stack.dequeue()

      if (row == n - 1 && col == m - 1) return true

      for ((rowChange, colChange) <- directions) {
        val (nextRow, nextCol) = (row + rowChange, col + colChange)
        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !seen.contains(nextRow, nextCol)) {
          if (math.abs(heights(row)(col) - heights(nextRow)(nextCol)) <= maxEffort) {
            seen.addOne(nextRow, nextCol)
            stack.addOne(nextRow, nextCol)
          }
        }
      }
    }


    false
  }

  var left = 0
  var right = -1
  for (array <- heights) {
    for (n <- array) {
      right = math.max(n, right)
    }
  }

  while (left <= right) {
    val mid = left + (right - left) / 2
    if (dfs(mid)) right = mid - 1
    else left = mid + 1
  }


  left
}