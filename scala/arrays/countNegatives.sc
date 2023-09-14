def countNegatives(grid: Array[Array[Int]]): Int = {
  grid.foldRight(0) { case (arr, acc) =>
    var count = 0
    var i = arr.length - 1
    while (i >= 0 && arr(i) < 0) {
      count += 1
      i -= 1
    }
    acc + count
  }
}