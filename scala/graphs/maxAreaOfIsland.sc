def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
  val visitedNodes = scala.collection.mutable.Set.empty[(Int, Int)]
  var maxAreaOfIsland = 0

  def dfs(x: Int, y: Int): Int = {
    if (
      x >= 0 && x < grid.length &&
        y >= 0 && y < grid.head.length &&
        grid(x)(y) == 1 &&
        !visitedNodes.contains((x, y))
    ) {
      visitedNodes.add((x, y))
      1 +
        dfs(x, y + 1) +
        dfs(x, y - 1) +
        dfs(x + 1, y) +
        dfs(x - 1, y)
    } else 0
  }

  for (x <- grid.indices) {
    for (y <- grid.head.indices) {
      if (grid(x)(y) == 1 && !visitedNodes.contains((x, y))) {
        maxAreaOfIsland = math.max(maxAreaOfIsland, dfs(x, y))
      }
    }
  }

  maxAreaOfIsland
}