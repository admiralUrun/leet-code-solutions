def solveNQueens(n: Int): List[List[String]] = {
  var answer: List[List[String]] = Nil

  def makeQueenString(col: Int): String = {
    val s = Array.fill(n)('.')
    s(col) = 'Q'
    s.mkString
  }

  def backtracking(
                    row: Int,
                    cols: List[Int],
                    diagonals: List[Int],
                    antiDiagonals: List[Int],
                    acc: List[String]
                  ): Unit = {
    if (row == n) answer = acc :: answer
    else {
      for (col <- 0 until n) {
        val diagonal = row - col
        val antiDiagonal = row + col
        if (!cols.contains(col) && !diagonals.contains(diagonal) && !antiDiagonals.contains(antiDiagonal)) {
          backtracking(row + 1, col :: cols, diagonal :: diagonals, antiDiagonal :: antiDiagonals, makeQueenString(col) :: acc)
        }
      }
    }
  }


  backtracking(0, Nil, Nil, Nil, Nil)
  answer
}