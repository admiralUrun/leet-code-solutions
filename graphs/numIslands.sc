def numIslands(grid: Array[Array[Char]]): Int = {
  val moves = Array((0, 1), (1, 0), (0, -1), (-1, 0))
  val visitedNodes = scala.collection.mutable.Set.empty[(Int, Int)]
  var islands = 0

  def validNode(x: Int, y: Int) = x >= 0 && x < grid.length && y >= 0 && y < grid.head.length && grid(x)(y) == '1'

  def dfs(x: Int, y: Int) = {
    val stack = scala.collection.mutable.Stack((x, y))
    while (stack.nonEmpty) {
      val (row, col) = stack.pop()
      for ((rowChange, colChange) <- moves) {
        val (newRow, newCol) = (row + rowChange, col + colChange)
        if (validNode(newRow, newCol) && !visitedNodes.contains((newRow, newCol))) {
          visitedNodes.add(newRow, newCol)
          stack.addOne(newRow, newCol)
        }
      }
    }
  }

  for (x <- grid.indices) {
    for (y <- grid.head.indices) {
      if (grid(x)(y) == '1' && !visitedNodes.contains((x, y))) {
        visitedNodes.add((x, y))
        dfs(x, y)
        islands += 1
      }
    }
  }

  islands
}