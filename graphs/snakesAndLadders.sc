def snakesAndLadders(board: Array[Array[Int]]): Int = {
  def currToCoordinates(curr: Int, n: Int): (Int, Int) = {
    val row = (curr - 1) / n
    var col = 0

    if (row % 2 == 0) col = (curr - 1) % n
    else col = n - 1 - (curr - 1) % n

    (n - 1 - row, col)
  }

  val last = board.length * board.length
  val queue = scala.collection.mutable.Queue((1, 0))
  val visited = Array.ofDim[Boolean](board.length, board.length)

  while (queue.nonEmpty) {
    val (curr, steps) = queue.dequeue()
    if (curr == last) return steps
    for (roll <- 1 to 6) {
      if (curr + roll <= board.length * board.length) {
        val next = curr + roll
        val (nextRow, nextCol) = currToCoordinates(next, board.length)

        if (!visited(nextRow)(nextCol)) {
          if (next == last || board(nextRow)(nextCol) == last) return steps + 1

          if (board(nextRow)(nextCol) != -1) queue.enqueue((board(nextRow)(nextCol), steps + 1))
          else queue.enqueue((next, steps + 1))

          visited(nextRow)(nextCol) = true
        }
      }
    }
  }

  -1
}