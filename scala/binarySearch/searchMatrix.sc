def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
  var left = 0
  val n = matrix.head.length
  var right = matrix.length * n - 1

  while (left <= right) {
    val mid = left + (right - left) / 2
    val row = mid / n
    val col = mid % n

    if (matrix(row)(col) == target) return true

    if (matrix(row)(col) < target) left = mid + 1
    else right = mid - 1
  }

  false
}