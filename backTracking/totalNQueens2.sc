def totalNQueens(n: Int): Int = {
  def totalNQueens(
                    row: Int,
                    diagonals: List[Int],
                    antiDiagonals: List[Int],
                    cols: List[Int],
                  ): Int = {
    if (row == n) return 1

    var solution = 0
    for (col <- 0 until n) {
      val diagonal = row - col
      val antiDiagonal = row + col
      if (!cols.contains(col) && !diagonals.contains(diagonal) && !antiDiagonals.contains(antiDiagonal)) {
        solution += totalNQueens(row + 1, diagonal :: diagonals, antiDiagonal :: antiDiagonals, col :: cols)
      }
    }

    solution
  }

  totalNQueens(0, Nil, Nil, Nil)
}