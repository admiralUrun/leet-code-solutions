def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
  val rows = maze.length
  val cols = maze.head.length

  val directions = Array((0, 1), (1, 0), (0, -1), (-1, 0))
  val queue = scala.collection.mutable.Queue(((entrance.head, entrance.last), 0)) //(Ordering.by(-_._2))

  maze(entrance.head)(entrance.last) = '-'

  while (queue.nonEmpty) {
    val (node, steps) = queue.dequeue()
    for (d <- directions) {
      val (newX, newY) = (node._1 + d._1, node._2 + d._2)
      if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze.head.length && maze(newX)(newY) == '.') {

        if (newX == 0 || newX == rows - 1 || newY == 0 || newY == cols - 1) return steps + 1

        maze(newX)(newY) = '-'
        queue.enqueue(((newX, newY), steps + 1))
      }
    }
  }
  -1
}