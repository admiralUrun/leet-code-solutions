def checkIfExist(arr: Array[Int]): Boolean = {
  var hashSet = Set.empty[Double]
  for (n <- arr) {
    if (hashSet.contains(n * 2) || hashSet.contains(n / 2d)) return true
    else hashSet += n
  }
  false
}