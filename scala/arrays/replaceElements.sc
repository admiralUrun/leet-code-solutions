def replaceElements(arr: Array[Int]): Array[Int] = {
  var biggestToTheRight = arr.last
  for (i <- 1 until arr.length) {
    val current = arr(arr.length - i)
    arr(arr.length - i) = biggestToTheRight
    if (biggestToTheRight < current) biggestToTheRight = current
  }
  arr(0) = biggestToTheRight
  arr(arr.length - 1) = -1
  arr
}