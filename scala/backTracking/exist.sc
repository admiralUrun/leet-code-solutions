def exist(board: Array[Array[Char]], word: String): Boolean = {
  val moves = Array((0, 1), (1, 0), (0, -1), (-1, 0))

  def backtrack(i: Int, row: Int, col: Int, visited: scala.collection.mutable.Set[(Int, Int)]): Boolean = {
    if (i == word.length) return true

    for ((rowChange, colChange) <- moves) {
      val newRow = row + rowChange
      val newCol = col + colChange
      if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.head.length) {
        if (!visited.contains(newRow, newCol) && word(i) == board(newRow)(newCol)) {
          val item = (newRow, newCol)
          visited.add(item)
          if (backtrack(i + 1, newRow, newCol, visited)) return true
          visited.remove(item)
        }
      }
    }

    false
  }

  for (row <- board.indices) {
    for (col <- board(row).indices) {
      if (board(row)(col) == word.head && backtrack(1, row, col, scala.collection.mutable.Set((row, col)))) return true
    }
  }
  false
}