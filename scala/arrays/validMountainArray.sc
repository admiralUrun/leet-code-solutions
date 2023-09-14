def validMountainArray(arr: Array[Int]): Boolean = {
  if (arr.length >= 3) {
    var i = 0
    var j = arr.length - 1
    while (arr(i) < arr(i + 1) && i + 1 < arr.length - 1) {
      i += 1
    }
    while (arr(j) < arr(j - 1) && j - 1 > 0) {
      j -= 1
    }
    i == j
  } else false
}