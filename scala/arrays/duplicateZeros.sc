def duplicateZeros(arr: Array[Int]): Unit = {
  var i = 0
  while (i < arr.length) {
    if (arr(i) == 0) {
      for (j <- (arr.length - 2) to i by -1) {
        arr(j + 1) = arr(j)
      }
      if (i < arr.length - 1) {
        arr(i + 1) = 0
        i += 1
      }
    }
    i += 1
  }
}