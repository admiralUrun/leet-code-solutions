def totalNQueens(n: Int): Int = {
  def totalNQueens(
                    row: Int,
                    diagonals: scala.collection.mutable.Set[Int],
                    antiDiagonals: scala.collection.mutable.Set[Int],
                    cols: scala.collection.mutable.Set[Int],
                  ): Int = {
    if (row == n) return 1

    var solution = 0
    for (col <- 0 until n) {
      val diagonal = row - col
      val antiDiagonal = row + col
      if (!cols.contains(col) && !diagonals.contains(diagonal) && !antiDiagonals.contains(antiDiagonal)) {
        cols.add(col)
        diagonals.add(diagonal)
        antiDiagonals.add(antiDiagonal)

        solution += totalNQueens(row + 1, diagonals, antiDiagonals, cols)

        cols.remove(col)
        diagonals.remove(diagonal)
        antiDiagonals.remove(antiDiagonal)
      }
    }

    solution
  }

  totalNQueens(0, scala.collection.mutable.Set(), scala.collection.mutable.Set(), scala.collection.mutable.Set())
}