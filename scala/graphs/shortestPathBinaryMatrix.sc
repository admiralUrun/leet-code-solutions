def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
  if (grid.head.head == 1 || grid.last.last == 1) return -1
  val queue = scala.collection.mutable.Queue(((0, 0), 1))
  val directions = Array((0, 1), (1, 0), (1, 1), (-1, -1), (-1, 1), (1, -1), (0, -1), (-1, 0))

  while (queue.nonEmpty) {
    val (node, steps) = queue.dequeue()
    if (node == (grid.length - 1, grid.length - 1)) return steps
    for ((rowChanges, colChanges) <- directions) {
      val (newRow, newCol) = (node._1 + rowChanges, node._2 + colChanges)
      if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length && grid(newRow)(newCol) == 0) {
        grid(newRow)(newCol) = 1
        queue.addOne((newRow, newCol), steps + 1)
      }
    }
  }

  -1
}