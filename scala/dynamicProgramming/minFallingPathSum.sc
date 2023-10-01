def minFallingPathSum(matrix: Array[Array[Int]]): Int = {
  val direction = Seq((1, -1), (1, 0), (1, 1))
  val cache = scala.collection.mutable.HashMap.empty[(Int, Int), Int]

  def minFallingPathSum(row: Int, col: Int): Int = {
    if (cache contains(row, col)) cache((row, col))
    else if (row == matrix.length - 1) matrix(row)(col)
    else {
      var res = Int.MaxValue

      for ((rowChange, colChange) <- direction) {
        val newRow = row + rowChange
        val newCol = col + colChange
        if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.head.length) {
          res = res min (matrix(row)(col) + minFallingPathSum(newRow, newCol))
        }
      }

      cache((row, col)) = res
      res
    }
  }

  var res = Int.MaxValue
  for (col <- matrix.head.indices) {
    res = res min minFallingPathSum(0, col)
  }

  res
}