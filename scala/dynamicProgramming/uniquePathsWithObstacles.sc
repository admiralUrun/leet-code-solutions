def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
  if (obstacleGrid.head.head == 1 || obstacleGrid.last.last == 1) return 0
  val map = Array.fill(obstacleGrid.length)(new Array[Int](obstacleGrid.head.length))
  map(0)(0) = 1

  for (row <- obstacleGrid.indices) {
    for (col <- obstacleGrid.head.indices) {
      if (obstacleGrid(row)(col) == 0) {
        if (row > 0) map(row)(col) += map(row - 1)(col)
        if (col > 0) map(row)(col) += map(row)(col - 1)
      }
    }
  }

  map.last.last
}